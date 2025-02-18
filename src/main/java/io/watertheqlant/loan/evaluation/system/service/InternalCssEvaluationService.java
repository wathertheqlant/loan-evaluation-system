package io.watertheqlant.loan.evaluation.system.service;

import io.watertheqlant.loan.evaluation.system.dao.InternalCssEvaluationScoreMapper;
import io.watertheqlant.loan.evaluation.system.dao.InternalCssGradePolicyMapper;
import io.watertheqlant.loan.evaluation.system.dao.SequenceMapper;
import io.watertheqlant.loan.evaluation.system.entity.*;
import io.watertheqlant.loan.evaluation.system.factory.InternalCssEvaluationScoreFactory;
import io.watertheqlant.loan.evaluation.system.vo.InternalEvaluationPolicyResult;
import io.watertheqlant.loan.evaluation.system.dao.InternalEvaluationPolicyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InternalCssEvaluationService {

  private final SequenceMapper sequenceMapper;
  private final InternalEvaluationPolicyMapper internalEvaluationPolicyMapper;
  private final InternalCssGradePolicyMapper internalCssGradePolicyMapper;
  private final InternalCssEvaluationScoreMapper internalCssEvaluationScoreMapper;

  public InternalCssEvaluationScore evaluate(Long customerId, ScbCreditInfo scbCreditInfo) {
    LocalDateTime now = LocalDateTime.now();
    List<InternalEvaluationPolicyResult> results = evaluateScore(scbCreditInfo, now);
    Integer scoreSum = results.stream()
      .filter(InternalEvaluationPolicyResult::isPass)
      .map(InternalEvaluationPolicyResult::getScore).reduce(0, Integer::sum);
    InternalCssGradePolicy internalCssGradePolicy = internalCssGradePolicyMapper.findByScoreSumAndRequestedAt(scoreSum, now);
    InternalCssEvaluationScore result = InternalCssEvaluationScoreFactory.create(now, customerId, scbCreditInfo.getId(), internalCssGradePolicy, results);

    return saveScore(result);
  }

  public List<InternalEvaluationPolicyResult> evaluateScore(ScbCreditInfo scbCreditInfo, LocalDateTime now) {
    List<InternalEvaluationPolicy> internalPolicies = internalEvaluationPolicyMapper.findAllByExpiredAtGreaterThanEqual(now);

    return internalPolicies.stream()
      .map(internalEvaluationPolicy -> internalEvaluationPolicy.evaluate(scbCreditInfo.getValueByCreditInfoDictionaryId(internalEvaluationPolicy.getCreditInfoDictionaryId())))
      .toList();
  }


  private InternalCssEvaluationScore saveScore(InternalCssEvaluationScore internalCssEvaluationScore) {
    var id = sequenceMapper.get(InternalCssEvaluationScore.TABLE_NAME);
    internalCssEvaluationScore.setId(id);

    internalCssEvaluationScore.getItems().forEach(item -> {
      var itemId = sequenceMapper.get(InternalCssEvaluationScoreItem.TABLE_NAME);

      item.setInternalCssEvaluationScoreId(id);
      item.setId(itemId);
    });
    internalCssEvaluationScoreMapper.save(internalCssEvaluationScore);
    return internalCssEvaluationScore;
  }

}

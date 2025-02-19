package io.watertheqlant.loan.evaluation.system.domain.service;

import io.watertheqlant.loan.evaluation.system.domain.dao.InternalCssEvaluationScoreMapper;
import io.watertheqlant.loan.evaluation.system.domain.dao.InternalCssGradePolicyMapper;
import io.watertheqlant.loan.evaluation.system.domain.dao.SequenceMapper;
import io.watertheqlant.loan.evaluation.system.domain.dto.InternalCssEvaluationResult;
import io.watertheqlant.loan.evaluation.system.domain.entity.*;
import io.watertheqlant.loan.evaluation.system.domain.vo.InternalEvaluationPolicyResult;
import io.watertheqlant.loan.evaluation.system.domain.factory.InternalCssEvaluationScoreFactory;
import io.watertheqlant.loan.evaluation.system.domain.dao.InternalEvaluationPolicyMapper;
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

  public InternalCssEvaluationResult findScoreHistoryByCustomerId(Long customerId) {
    LocalDateTime now = LocalDateTime.now();
    var scoreHistory = internalCssEvaluationScoreMapper.findByCustomerIdAndExpiredAtGreaterThanEqual(customerId, now);
    if (scoreHistory == null) {
      return InternalCssEvaluationResult.builder()
        .customerId(customerId)
        .build();
    }
    InternalCssGradePolicy internalCssEvaluationScore = internalCssGradePolicyMapper.findById(scoreHistory.getInternalCssGradePolicyId());
    return InternalCssEvaluationResult.builder()
      .customerId(customerId)
      .minLoanAmount(internalCssEvaluationScore.getMinLoanAmount())
      .maxLoanAmount(internalCssEvaluationScore.getMaxLoanAmount())
      .interestRate(internalCssEvaluationScore.getInterestRate())
      .minLoanTerm(internalCssEvaluationScore.getMinLoanTerm())
      .maxLoanTerm(internalCssEvaluationScore.getMaxLoanTerm())
      .build();
  }

  public InternalCssEvaluationResult evaluate(Long customerId, ScbCreditInfo scbCreditInfo) {
    LocalDateTime now = LocalDateTime.now();
    List<InternalEvaluationPolicyResult> results = evaluateScore(scbCreditInfo, now);
    Integer scoreSum = results.stream()
      .filter(InternalEvaluationPolicyResult::isPass)
      .map(InternalEvaluationPolicyResult::getScore).reduce(0, Integer::sum);
    InternalCssGradePolicy internalCssGradePolicy = internalCssGradePolicyMapper.findByScoreSumAndRequestedAt(scoreSum, now);
    InternalCssEvaluationScore result = InternalCssEvaluationScoreFactory.create(now, customerId, scbCreditInfo.getId(), internalCssGradePolicy, results);

    saveScore(result);

    return InternalCssEvaluationResult.builder()
      .customerId(customerId)
      .minLoanAmount(internalCssGradePolicy.getMinLoanAmount())
      .maxLoanAmount(internalCssGradePolicy.getMaxLoanAmount())
      .interestRate(internalCssGradePolicy.getInterestRate())
      .minLoanTerm(internalCssGradePolicy.getMinLoanTerm())
      .maxLoanTerm(internalCssGradePolicy.getMaxLoanTerm())
      .build();
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

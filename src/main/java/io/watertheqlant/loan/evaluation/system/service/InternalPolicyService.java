package io.watertheqlant.loan.evaluation.system.service;

import io.watertheqlant.loan.evaluation.system.InternalPolicyEvaluationResult;
import io.watertheqlant.loan.evaluation.system.dao.InternalPolicyMapper;
import io.watertheqlant.loan.evaluation.system.entity.InternalPolicy;
import io.watertheqlant.loan.evaluation.system.entity.ScbCreditInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InternalPolicyService {

  private final InternalPolicyMapper internalPolicyMapper;

  public List<InternalPolicyEvaluationResult> evaluate(ScbCreditInfo scbCreditInfo) {
    LocalDate now = LocalDate.now();
    List<InternalPolicy> internalPolicies = internalPolicyMapper.findAllByExpiredDateGreaterThanEqual(now);
    return internalPolicies.stream()
        .map(internalPolicy -> internalPolicy.evaluate(scbCreditInfo.getValue(internalPolicy.getCreditInfoDictionaryId())))
        .toList();
  }

}

package io.watertheqlant.loan.evaluation.system;


import io.watertheqlant.loan.evaluation.system.type.InternalPolicyEvaluationResultType;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InternalPolicyEvaluationResult {

  private final Long interPolicyId;
  private final InternalPolicyEvaluationResultType resultType;
  private final BigDecimal customerValue;
  private final Integer score;

  private InternalPolicyEvaluationResult(Long interPolicyId,
                                         InternalPolicyEvaluationResultType resultType,
                                         BigDecimal customerValue,
                                         Integer score) {
    this.interPolicyId = interPolicyId;
    this.resultType = resultType;
    this.customerValue = customerValue;
  }

  public static InternalPolicyEvaluationResult pass(Long interPolicyId,
                                                    BigDecimal customerValue,
                                                    Integer score) {
    return new InternalPolicyEvaluationResult(
      interPolicyId, InternalPolicyEvaluationResultType.PASS, customerValue, score
    );
  }

  public static InternalPolicyEvaluationResult fail(Long interPolicyId,
                                                    BigDecimal customerValue,
                                                    Integer score) {
    return new InternalPolicyEvaluationResult(
      interPolicyId, InternalPolicyEvaluationResultType.FAIL, customerValue, score
    );
  }

  public boolean isPass() {
    return InternalPolicyEvaluationResultType.PASS.equals(resultType);
  }

  public boolean isFail() {
    return InternalPolicyEvaluationResultType.FAIL.equals(resultType);
  }

}

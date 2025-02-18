package io.watertheqlant.loan.evaluation.system.vo;


import io.watertheqlant.loan.evaluation.system.type.InternalPolicyEvaluationResultType;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InternalEvaluationPolicyResult {

  private final Long internalEvaluationPolicyId;
  private final InternalPolicyEvaluationResultType evaluationResultType;
  private final BigDecimal evaluatedValue;
  private final Integer score;

  private InternalEvaluationPolicyResult(Long internalEvaluationPolicyId,
                                         InternalPolicyEvaluationResultType evaluationResultType,
                                         BigDecimal evaluatedValue,
                                         Integer score) {
    this.internalEvaluationPolicyId = internalEvaluationPolicyId;
    this.evaluationResultType = evaluationResultType;
    this.evaluatedValue = evaluatedValue;
    this.score = score;
  }

  public static InternalEvaluationPolicyResult pass(Long interPolicyId,
                                                    BigDecimal customerValue,
                                                    Integer score) {
    return new InternalEvaluationPolicyResult(
      interPolicyId, InternalPolicyEvaluationResultType.PASS, customerValue, score
    );
  }

  public static InternalEvaluationPolicyResult fail(Long interPolicyId,
                                                    BigDecimal customerValue, Integer evaluationScore) {
    return new InternalEvaluationPolicyResult(
      interPolicyId, InternalPolicyEvaluationResultType.FAIL, customerValue, evaluationScore
    );
  }

  public boolean isPass() {
    return InternalPolicyEvaluationResultType.PASS.equals(evaluationResultType);
  }

  public boolean isFail() {
    return InternalPolicyEvaluationResultType.FAIL.equals(evaluationResultType);
  }

}

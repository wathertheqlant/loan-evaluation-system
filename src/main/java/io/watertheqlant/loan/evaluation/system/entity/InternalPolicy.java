package io.watertheqlant.loan.evaluation.system.entity;

import io.watertheqlant.loan.evaluation.system.InternalPolicyEvaluationResult;
import io.watertheqlant.loan.evaluation.system.type.OperatorType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalPolicy {

  public static final String tableName = "internal_policies";

  private Long id;
  private Long creditInfoDictionaryId;
  private String description;
  private OperatorType operator1;
  private OperatorType operator2;
  private BigDecimal value1;
  private BigDecimal value2;
  private Integer evaluationScore;
  private LocalDate expiredDate;

  public InternalPolicyEvaluationResult evaluate(BigDecimal value) {
    if(operator2 == null) {
      return singleOperatorEvaluation(value);
    } else {
      return doubleOperatorEvaluation(value);
    }
  }

  private InternalPolicyEvaluationResult singleOperatorEvaluation(BigDecimal value) {
    if(operator1.evaluate(value, value1)) {
      return InternalPolicyEvaluationResult.pass(id, value, evaluationScore);
    } else {
      return InternalPolicyEvaluationResult.fail(id, value, evaluationScore);
    }
  }

  private InternalPolicyEvaluationResult doubleOperatorEvaluation(BigDecimal value) {
    if(operator1.evaluate(value, value1) && operator2.evaluate(value, value2)) {
      return InternalPolicyEvaluationResult.pass(id, value, evaluationScore);
    } else {
      return InternalPolicyEvaluationResult.fail(id, value, evaluationScore);
    }
  }

}

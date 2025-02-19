package io.watertheqlant.loan.evaluation.system.domain.entity;

import io.watertheqlant.loan.evaluation.system.domain.type.OperatorType;
import io.watertheqlant.loan.evaluation.system.domain.vo.InternalEvaluationPolicyResult;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalEvaluationPolicy {

  public static final String TABLE_NAME = "internal_evaluation_policies";

  private Long id;
  private Long creditInfoDictionaryId;
  private String description;
  private OperatorType operator1;
  private OperatorType operator2;
  private BigDecimal value1;
  private BigDecimal value2;
  private Integer evaluationScore;
  private LocalDateTime expiredAt;

  public InternalEvaluationPolicyResult evaluate(BigDecimal value) {
    if(operator2 == null) {
      return singleOperatorEvaluation(value);
    } else {
      return doubleOperatorEvaluation(value);
    }
  }

  private InternalEvaluationPolicyResult singleOperatorEvaluation(BigDecimal value) {
    if(operator1.evaluate(value, value1)) {
      return InternalEvaluationPolicyResult.pass(id, value, evaluationScore);
    } else {
      return InternalEvaluationPolicyResult.fail(id, value, evaluationScore);
    }
  }

  private InternalEvaluationPolicyResult doubleOperatorEvaluation(BigDecimal value) {
    if(operator1.evaluate(value, value1) && operator2.evaluate(value, value2)) {
      return InternalEvaluationPolicyResult.pass(id, value, evaluationScore);
    } else {
      return InternalEvaluationPolicyResult.fail(id, value, evaluationScore);
    }
  }

}

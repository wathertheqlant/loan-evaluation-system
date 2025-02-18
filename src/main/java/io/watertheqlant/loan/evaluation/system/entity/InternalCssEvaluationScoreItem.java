package io.watertheqlant.loan.evaluation.system.entity;

import io.watertheqlant.loan.evaluation.system.type.InternalPolicyEvaluationResultType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalCssEvaluationScoreItem {

  public static final String TABLE_NAME = "internal_css_evaluation_score_items";

  private Long id;
  private Long customerId;
  private Long internalCssEvaluationScoreId;
  private Long internalEvaluationPolicyId;
  private InternalPolicyEvaluationResultType evaluationResultType;
  private BigDecimal evaluatedValue;
  private Integer score;
}

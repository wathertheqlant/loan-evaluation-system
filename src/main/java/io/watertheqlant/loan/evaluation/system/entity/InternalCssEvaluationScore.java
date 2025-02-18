package io.watertheqlant.loan.evaluation.system.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalCssEvaluationScore {

  public static final String TABLE_NAME = "internal_css_evaluation_scores";

  private Long id;
  private Long customerId;
  private Long internalCssGradePolicyId;
  private Integer cssGrade;
  private Long scbCreditInfoId;
  private LocalDateTime expiredAt;
  private LocalDateTime evaluatedAt;

  @Builder.Default
  private List<InternalCssEvaluationScoreItem> items = new ArrayList<>();
}

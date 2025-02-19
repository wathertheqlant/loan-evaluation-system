package io.watertheqlant.loan.evaluation.system.domain.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalCssGradePolicy {

  public static final String TABLE_NAME = "internal_css_grade_policies";

  private Long id;
  private Integer cssGrade;
  private Integer minEvaluationScore;
  private Integer maxEvaluationScore;
  private Integer minLoanAmount;
  private Integer maxLoanAmount;
  private BigDecimal interestRate;
  private Integer minLoanTerm;
  private Integer maxLoanTerm;
  private LocalDateTime expiredAt;

}

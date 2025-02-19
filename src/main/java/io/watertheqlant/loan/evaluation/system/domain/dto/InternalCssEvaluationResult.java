package io.watertheqlant.loan.evaluation.system.domain.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalCssEvaluationResult {
  private Long customerId;
  private Integer minLoanAmount;
  private Integer maxLoanAmount;
  private BigDecimal interestRate;
  private Integer minLoanTerm;
  private Integer maxLoanTerm;

  public boolean hasResult() {
    return minLoanAmount != null && maxLoanAmount != null && interestRate != null && minLoanTerm != null && maxLoanTerm != null;
  }
}

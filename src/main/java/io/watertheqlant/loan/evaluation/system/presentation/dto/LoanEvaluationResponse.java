package io.watertheqlant.loan.evaluation.system.presentation.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanEvaluationResponse {

  private String name;
  private String jumin;
  private Integer minLoanAmount;
  private Integer maxLoanAmount;
  private BigDecimal interestRate;
  private Integer minLoanTerm;
  private Integer maxLoanTerm;

}

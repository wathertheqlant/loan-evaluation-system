package io.watertheqlant.loan.evaluation.system.presentation.controller;

import io.watertheqlant.loan.evaluation.system.presentation.application.LoanEvaluationApplication;
import io.watertheqlant.loan.evaluation.system.presentation.dto.LoanEvaluationRequest;
import io.watertheqlant.loan.evaluation.system.presentation.dto.LoanEvaluationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoanEvaluationController {

  private final LoanEvaluationApplication loanEvaluationApplication;

  @PostMapping("/loans/evaluations")
  public LoanEvaluationResponse evaluateLoan(@RequestBody LoanEvaluationRequest request) {
    var result = loanEvaluationApplication.evaluate(request.getName(), request.getJumin());
    return LoanEvaluationResponse.builder()
      .name(request.getName())
      .jumin(request.getJumin())
      .minLoanAmount(result.getMinLoanAmount())
      .maxLoanAmount(result.getMaxLoanAmount())
      .interestRate(result.getInterestRate())
      .minLoanTerm(result.getMinLoanTerm())
      .maxLoanTerm(result.getMaxLoanTerm())
      .build();
  }
}

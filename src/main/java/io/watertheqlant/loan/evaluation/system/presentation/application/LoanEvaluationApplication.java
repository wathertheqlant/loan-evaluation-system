package io.watertheqlant.loan.evaluation.system.presentation.application;

import io.watertheqlant.loan.evaluation.system.domain.dto.InternalCssEvaluationResult;
import io.watertheqlant.loan.evaluation.system.domain.entity.Customer;
import io.watertheqlant.loan.evaluation.system.domain.entity.InternalCssEvaluationScore;
import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfo;
import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfoDetail;
import io.watertheqlant.loan.evaluation.system.domain.service.CustomerService;
import io.watertheqlant.loan.evaluation.system.domain.service.InternalCssEvaluationService;
import io.watertheqlant.loan.evaluation.system.domain.service.ScbCreditInfoService;
import io.watertheqlant.loan.evaluation.system.presentation.annotation.Application;
import io.watertheqlant.loan.evaluation.system.presentation.dto.LoanEvaluationRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Application
public class LoanEvaluationApplication {

  private final CustomerService customerService;
  private final InternalCssEvaluationService internalCssEvaluationService;
  private final ScbCreditInfoService scbCreditInfoService;

  public InternalCssEvaluationResult evaluate(String name, String jumin) {
    Customer customer = customerService.getOrSaveCustomer(name, jumin);
    InternalCssEvaluationResult foundScoreHistory = internalCssEvaluationService.findScoreHistoryByCustomerId(customer.getId());

    if (foundScoreHistory.hasResult()) {
      return foundScoreHistory;
    }

    ScbCreditInfo scbCreditInfo = scbCreditInfoService.queryAndSave(customer);
    return internalCssEvaluationService.evaluate(customer.getId(), scbCreditInfo);
  }

}

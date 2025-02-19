package io.watertheqlant.loan.evaluation.system.service;

import io.watertheqlant.loan.evaluation.system.domain.dto.InternalCssEvaluationResult;
import io.watertheqlant.loan.evaluation.system.domain.entity.Customer;
import io.watertheqlant.loan.evaluation.system.domain.entity.InternalCssEvaluationScore;
import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfo;
import io.watertheqlant.loan.evaluation.system.domain.service.InternalCssEvaluationService;
import io.watertheqlant.loan.evaluation.system.domain.service.ScbCreditInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class InternalCssEvaluationServiceTest {

  @Autowired
  private ScbCreditInfoService scbCreditInfoService;

  @Autowired
  private InternalCssEvaluationService internalCssEvaluationService;

  @Test
  void evaluate() {
    Customer customer = Customer.builder()
      .id(1L)
      .customerName("홍길동")
      .customerJumin("9301011234567")
      .build();
    ScbCreditInfo scbCreditInfo = scbCreditInfoService.queryAndSave(customer);
    InternalCssEvaluationResult result = internalCssEvaluationService.evaluate(1L, scbCreditInfo);
    assertNotNull(result);
  }

}

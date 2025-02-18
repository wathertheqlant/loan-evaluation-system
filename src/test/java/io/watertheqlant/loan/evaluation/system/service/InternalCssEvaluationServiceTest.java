package io.watertheqlant.loan.evaluation.system.service;

import io.watertheqlant.loan.evaluation.system.entity.InternalCssEvaluationScore;
import io.watertheqlant.loan.evaluation.system.entity.ScbCreditInfo;
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
    ScbCreditInfo scbCreditInfo = scbCreditInfoService.queryAndSave(1L, "9301011234567");
    InternalCssEvaluationScore result = internalCssEvaluationService.evaluate(1L, scbCreditInfo);
    assertNotNull(result);
  }

}

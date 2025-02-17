package io.watertheqlant.loan.evaluation.system.infrastructure.scb;

import io.watertheqlant.loan.evaluation.system.service.ScbCreditInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@SpringBootTest
class ScbCreditInfoServiceTest {

  @Autowired
  private ScbCreditInfoService scbCreditInfoService;

  @Test
  void queryAndSave() {
    var result = scbCreditInfoService.queryAndSave(1L, "9301011234567");
    System.out.println(result);
  }

}

package io.watertheqlant.loan.evaluation.system.infrastructure.scb;

import io.watertheqlant.loan.evaluation.system.domain.entity.Customer;
import io.watertheqlant.loan.evaluation.system.domain.service.ScbCreditInfoService;
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
    Customer customer = Customer.builder()
      .id(1L)
      .customerName("홍길동")
      .customerJumin("9301011234567")
      .build();
    var result = scbCreditInfoService.queryAndSave(customer);
    System.out.println(result);
  }

}

package io.watertheqlant.loan.evaluation.system.domain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

  @Autowired
  private CustomerService customerService;

  @Test
  void getOrSaveCustomer() {
    String name = "홍길동";
    String jumin = "1234561234567";

    var result = customerService.getOrSaveCustomer(name, jumin);

    assertNotNull(result);
  }

}

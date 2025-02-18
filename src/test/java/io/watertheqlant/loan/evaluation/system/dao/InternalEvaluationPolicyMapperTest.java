package io.watertheqlant.loan.evaluation.system.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InternalEvaluationPolicyMapperTest {

  @Autowired
  private InternalEvaluationPolicyMapper internalEvaluationPolicyMapper;

  @Test
  void findAllByExpiredDateGreaterThanEqual() {
    assertNotNull(internalEvaluationPolicyMapper.findAllByExpiredAtGreaterThanEqual(LocalDateTime.now()));
  }

}

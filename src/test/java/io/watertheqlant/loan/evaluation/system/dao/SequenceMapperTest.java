package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.domain.dao.SequenceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SequenceMapperTest {

  @Autowired
  private SequenceMapper sequenceMapper;

  @Test
  void nextValue() {
    var result = sequenceMapper.get("test");
    System.out.println(result);
  }

}

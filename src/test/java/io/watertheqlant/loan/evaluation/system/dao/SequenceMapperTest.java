package io.watertheqlant.loan.evaluation.system.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

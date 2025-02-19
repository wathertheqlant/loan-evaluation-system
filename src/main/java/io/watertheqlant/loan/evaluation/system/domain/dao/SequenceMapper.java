package io.watertheqlant.loan.evaluation.system.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
public interface SequenceMapper {

  default Long get(String sequenceName) {
    var result = getNextSequenceValue(sequenceName);
    incrementSequenceValue(sequenceName);
    return result;
  }

  Long getNextSequenceValue(String sequenceName);
  void incrementSequenceValue(String sequenceName);

}

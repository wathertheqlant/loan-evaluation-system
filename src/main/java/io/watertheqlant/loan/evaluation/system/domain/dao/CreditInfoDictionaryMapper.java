package io.watertheqlant.loan.evaluation.system.domain.dao;

import io.watertheqlant.loan.evaluation.system.domain.entity.CreditInfoDictionary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CreditInfoDictionaryMapper {

  CreditInfoDictionary findCreditInfoDictionaryByTypeName(String typeName, String creditBureauName);

}

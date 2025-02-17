package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.entity.ScbCreditInfoDetail;
import io.watertheqlant.loan.evaluation.system.entity.ScbCreditInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScbCreditInfoMapper {

  default void save(ScbCreditInfo scbCreditInfo) {
    saveScbCreditInfo(scbCreditInfo);
    scbCreditInfo.getDetails().forEach(this::saveScbCreditDetailInfo);
  }

  void saveScbCreditDetailInfo(ScbCreditInfoDetail sbcCreditGradeDetailInfo);

  void saveScbCreditInfo(ScbCreditInfo scbCreditInfo);

}

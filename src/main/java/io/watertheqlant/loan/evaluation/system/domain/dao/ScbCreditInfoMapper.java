package io.watertheqlant.loan.evaluation.system.domain.dao;

import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfoDetail;
import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfo;
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

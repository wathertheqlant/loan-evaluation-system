package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.entity.InternalPolicy;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface InternalPolicyMapper {

  List<InternalPolicy> findAllByExpiredDateGreaterThanEqual(LocalDate expiredDate);
}

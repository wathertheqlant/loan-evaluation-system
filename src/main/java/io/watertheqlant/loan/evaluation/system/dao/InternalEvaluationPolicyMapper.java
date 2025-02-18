package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.entity.InternalEvaluationPolicy;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface InternalEvaluationPolicyMapper {

  List<InternalEvaluationPolicy> findAllByExpiredAtGreaterThanEqual(LocalDateTime requestedAt);
}

package io.watertheqlant.loan.evaluation.system.domain.dao;

import io.watertheqlant.loan.evaluation.system.domain.entity.InternalEvaluationPolicy;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface InternalEvaluationPolicyMapper {

  List<InternalEvaluationPolicy> findAllByExpiredAtGreaterThanEqual(LocalDateTime requestedAt);
}

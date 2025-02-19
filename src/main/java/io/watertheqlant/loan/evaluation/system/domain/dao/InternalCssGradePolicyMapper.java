package io.watertheqlant.loan.evaluation.system.domain.dao;

import io.watertheqlant.loan.evaluation.system.domain.entity.InternalCssEvaluationScore;
import io.watertheqlant.loan.evaluation.system.domain.entity.InternalCssGradePolicy;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface InternalCssGradePolicyMapper {

  InternalCssGradePolicy findByScoreSumAndRequestedAt(Integer scoreSum, LocalDateTime requestedAt);

  InternalCssGradePolicy findById(Long internalCssGradePolicyId);
}

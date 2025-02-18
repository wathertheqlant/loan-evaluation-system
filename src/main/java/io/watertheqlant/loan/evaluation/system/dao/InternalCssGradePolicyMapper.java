package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.entity.InternalCssGradePolicy;

import java.time.LocalDateTime;

public interface InternalCssGradePolicyMapper {

  InternalCssGradePolicy findByScoreSumAndRequestedAt(Integer scoreSum, LocalDateTime requestedAt);
}

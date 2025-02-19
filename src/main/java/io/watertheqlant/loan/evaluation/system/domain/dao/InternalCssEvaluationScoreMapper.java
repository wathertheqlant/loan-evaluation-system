package io.watertheqlant.loan.evaluation.system.domain.dao;

import io.watertheqlant.loan.evaluation.system.domain.entity.InternalCssEvaluationScore;
import io.watertheqlant.loan.evaluation.system.domain.entity.InternalCssEvaluationScoreItem;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface InternalCssEvaluationScoreMapper {

  default void save(InternalCssEvaluationScore internalCssEvaluationScore) {
    saveInternalCssEvaluationScore(internalCssEvaluationScore);
    internalCssEvaluationScore.getItems().forEach(this::saveInternalCssEvaluationScoreItem);
  }

  void saveInternalCssEvaluationScore(InternalCssEvaluationScore internalCssEvaluationScore);

  void saveInternalCssEvaluationScoreItem(InternalCssEvaluationScoreItem internalCssEvaluationScoreItem);

  InternalCssEvaluationScore findByCustomerIdAndExpiredAtGreaterThanEqual(Long customerId, LocalDateTime requestedAt);
}

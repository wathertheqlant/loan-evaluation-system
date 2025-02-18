package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.entity.InternalCssEvaluationScore;
import io.watertheqlant.loan.evaluation.system.entity.InternalCssEvaluationScoreItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InternalCssEvaluationScoreMapper {

  default void save(InternalCssEvaluationScore internalCssEvaluationScore) {
    saveInternalCssEvaluationScore(internalCssEvaluationScore);
    internalCssEvaluationScore.getItems().forEach(this::saveInternalCssEvaluationScoreItem);
  }

  void saveInternalCssEvaluationScore(InternalCssEvaluationScore internalCssEvaluationScore);

  void saveInternalCssEvaluationScoreItem(InternalCssEvaluationScoreItem internalCssEvaluationScoreItem);
}

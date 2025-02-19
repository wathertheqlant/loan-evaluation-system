package io.watertheqlant.loan.evaluation.system.domain.type;

import lombok.Getter;

@Getter
public enum ScbCreditInfoCalculationTypeName {
  APPROVED_INCOME("approved_income");

  private final String typeName;
  ScbCreditInfoCalculationTypeName(String typeName) {
    this.typeName = typeName;
  }

}

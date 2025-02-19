package io.watertheqlant.loan.evaluation.system.domain.type;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum OperatorType {
  EQUALS("==") {
    @Override
    public boolean evaluate(BigDecimal left, BigDecimal right) {
      return left.compareTo(right) == 0;
    }
  },
  NOT_EQUALS("!=") {
    @Override
    public boolean evaluate(BigDecimal left, BigDecimal right) {
      return left.compareTo(right) != 0;
    }
  },
  GREATER_THAN(">") {
    @Override
    public boolean evaluate(BigDecimal left, BigDecimal right) {
      return left.compareTo(right) > 0;
    }
  },
  GREATER_THAN_OR_EQUALS(">=") {
    @Override
    public boolean evaluate(BigDecimal left, BigDecimal right) {
      return left.compareTo(right) >= 0;
    }
  },
  LESS_THAN("<") {
    @Override
    public boolean evaluate(BigDecimal left, BigDecimal right) {
      return left.compareTo(right) < 0;
    }
  },
  LESS_THAN_OR_EQUALS("<=") {
    @Override
    public boolean evaluate(BigDecimal left, BigDecimal right) {
      return left.compareTo(right) <= 0;
    }
  };

  private final String expression;

  OperatorType(String expression) {
    this.expression = expression;
  }

  public abstract boolean evaluate(BigDecimal left, BigDecimal right);

}

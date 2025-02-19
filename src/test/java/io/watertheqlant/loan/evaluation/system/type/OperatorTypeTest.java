package io.watertheqlant.loan.evaluation.system.type;

import io.watertheqlant.loan.evaluation.system.domain.type.OperatorType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTypeTest {
    private static final BigDecimal ZERO = BigDecimal.ZERO;
    private static final BigDecimal ONE = BigDecimal.ONE;
    private static final BigDecimal TEN = BigDecimal.TEN;
    private static final BigDecimal NEGATIVE_ONE = BigDecimal.ONE.negate();

    @Test
    void equalsShouldReturnTrueWhenValuesAreSame() {
      assertThat(OperatorType.EQUALS.evaluate(ONE, ONE)).isTrue();
      assertThat(OperatorType.EQUALS.evaluate(ZERO, ZERO)).isTrue();
    }

    @Test
    void equalsShouldReturnFalseWhenValuesAreDifferent() {
      assertThat(OperatorType.EQUALS.evaluate(ONE, TEN)).isFalse();
    }

    @Test
    void notEqualsShouldReturnTrueWhenValuesAreDifferent() {
      assertThat(OperatorType.NOT_EQUALS.evaluate(ONE, TEN)).isTrue();
      assertThat(OperatorType.NOT_EQUALS.evaluate(ZERO, ONE)).isTrue();
    }

    @Test
    void notEqualsShouldReturnFalseWhenValuesAreSame() {
      assertThat(OperatorType.NOT_EQUALS.evaluate(ONE, ONE)).isFalse();
    }

    @Test
    void greaterThanShouldReturnTrueWhenLeftIsGreater() {
      assertThat(OperatorType.GREATER_THAN.evaluate(TEN, ONE)).isTrue();
      assertThat(OperatorType.GREATER_THAN.evaluate(ONE, ZERO)).isTrue();
    }

    @Test
    void greaterThanShouldReturnFalseWhenLeftIsLessOrEqual() {
      assertThat(OperatorType.GREATER_THAN.evaluate(ONE, TEN)).isFalse();
      assertThat(OperatorType.GREATER_THAN.evaluate(ONE, ONE)).isFalse();
    }

    @Test
    void greaterThanOrEqualsShouldReturnTrueWhenLeftIsGreaterOrEqual() {
      assertThat(OperatorType.GREATER_THAN_OR_EQUALS.evaluate(TEN, ONE)).isTrue();
      assertThat(OperatorType.GREATER_THAN_OR_EQUALS.evaluate(ONE, ONE)).isTrue();
    }

    @Test
    void greaterThanOrEqualsShouldReturnFalseWhenLeftIsLess() {
      assertThat(OperatorType.GREATER_THAN_OR_EQUALS.evaluate(ONE, TEN)).isFalse();
    }

    @Test
    void lessThanShouldReturnTrueWhenLeftIsLess() {
      assertThat(OperatorType.LESS_THAN.evaluate(ONE, TEN)).isTrue();
      assertThat(OperatorType.LESS_THAN.evaluate(NEGATIVE_ONE, ZERO)).isTrue();
    }

    @Test
    void lessThanShouldReturnFalseWhenLeftIsGreaterOrEqual() {
      assertThat(OperatorType.LESS_THAN.evaluate(TEN, ONE)).isFalse();
      assertThat(OperatorType.LESS_THAN.evaluate(ONE, ONE)).isFalse();
    }

    @Test
    void lessThanOrEqualsShouldReturnTrueWhenLeftIsLessOrEqual() {
      assertThat(OperatorType.LESS_THAN_OR_EQUALS.evaluate(ONE, TEN)).isTrue();
      assertThat(OperatorType.LESS_THAN_OR_EQUALS.evaluate(ONE, ONE)).isTrue();
    }

    @Test
    void lessThanOrEqualsShouldReturnFalseWhenLeftIsGreater() {
      assertThat(OperatorType.LESS_THAN_OR_EQUALS.evaluate(TEN, ONE)).isFalse();
    }

    @Test
    void getExpressionShouldReturnCorrectSymbol() {
      assertThat(OperatorType.EQUALS.getExpression()).isEqualTo("==");
      assertThat(OperatorType.NOT_EQUALS.getExpression()).isEqualTo("!=");
      assertThat(OperatorType.GREATER_THAN.getExpression()).isEqualTo(">");
      assertThat(OperatorType.GREATER_THAN_OR_EQUALS.getExpression()).isEqualTo(">=");
      assertThat(OperatorType.LESS_THAN.getExpression()).isEqualTo("<");
      assertThat(OperatorType.LESS_THAN_OR_EQUALS.getExpression()).isEqualTo("<=");
    }
}

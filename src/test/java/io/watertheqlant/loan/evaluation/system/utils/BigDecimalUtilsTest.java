package io.watertheqlant.loan.evaluation.system.utils;

import io.watertheqlant.loan.evaluation.system.domain.utils.BigDecimalUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BigDecimalUtilsTest {

  @Test
  void percentOfPositiveValueAndRate() {
    BigDecimalUtils utils = new BigDecimalUtils();
    BigDecimal result = utils.percent(new BigDecimal("100"), new BigDecimal("10"));
    assertThat(result).isEqualByComparingTo(new BigDecimal("10"));
  }

  @Test
  void percentOfNegativeValueAndPositiveRate() {
    BigDecimalUtils utils = new BigDecimalUtils();
    BigDecimal result = utils.percent(new BigDecimal("-100"), new BigDecimal("10"));
    assertThat(result).isEqualByComparingTo(new BigDecimal("-10"));
  }

}

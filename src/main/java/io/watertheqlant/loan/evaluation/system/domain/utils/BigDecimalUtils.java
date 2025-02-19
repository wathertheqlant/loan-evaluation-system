package io.watertheqlant.loan.evaluation.system.domain.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

  public static BigDecimal percent(BigDecimal value, BigDecimal rate) {
    return value.multiply(rate).divide(new BigDecimal(100), 0, RoundingMode.HALF_UP);
  }

}

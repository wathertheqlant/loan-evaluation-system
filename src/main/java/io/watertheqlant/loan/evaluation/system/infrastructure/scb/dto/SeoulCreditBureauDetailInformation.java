package io.watertheqlant.loan.evaluation.system.infrastructure.scb.dto;

import io.watertheqlant.loan.evaluation.system.infrastructure.scb.type.DataType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeoulCreditBureauDetailInformation {
  private String name;
  private String description;
  private DataType type;
  private String value;

  public Integer toIntValue() {
    return Integer.parseInt(value);
  }

  public Long toLongValue() {
    return Long.parseLong(value);
  }

  public BigDecimal toBigDecimalValue() {
    return new BigDecimal(value);
  }

  public Boolean toBooleanValue() {
    return Boolean.parseBoolean(value);
  }

}

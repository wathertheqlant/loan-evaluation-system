package io.watertheqlant.loan.evaluation.system.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScbCreditInfo {

  public static final String TABLE_NAME = "scb_credit_info";

  private Long id;
  private Long customerId;
  private LocalDate requestDate;

  @Builder.Default
  private List<ScbCreditInfoDetail> details = new ArrayList<>();

  public BigDecimal getValue(Long creditInfoDictionaryId) {
    return details.stream()
      .filter(detail -> detail.getCreditInfoDictionaryId().equals(creditInfoDictionaryId))
      .findFirst()
      .map(ScbCreditInfoDetail::getValue)
      .map(ScbCreditInfo::parseDecimal)
      .orElse(BigDecimal.ZERO);
  }

  private static BigDecimal parseDecimal(String e) {
    if (e.equals("true")) {
      return BigDecimal.ONE;
    } else if (e.equals("false")) {
      return BigDecimal.ZERO;
    } else {
      return new BigDecimal(e);
    }
  }
}

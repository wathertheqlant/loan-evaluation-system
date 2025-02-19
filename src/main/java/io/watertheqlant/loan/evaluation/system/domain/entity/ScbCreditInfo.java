package io.watertheqlant.loan.evaluation.system.domain.entity;

import io.watertheqlant.loan.evaluation.system.domain.type.ScbCreditInfoCalculationTypeName;
import io.watertheqlant.loan.evaluation.system.domain.utils.BigDecimalUtils;
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
  public static final BigDecimal NON_REGULAR_EMPLOYEE_APPROVAL_RATE = BigDecimal.valueOf(70);

  private Long id;
  private Long customerId;
  private LocalDate requestDate;

  @Builder.Default
  private List<ScbCreditInfoDetail> details = new ArrayList<>();

  public BigDecimal getValueByCreditInfoDictionaryId(Long creditInfoDictionaryId) {
    return details.stream()
      .filter(detail -> detail.getCreditInfoDictionaryId().equals(creditInfoDictionaryId))
      .findFirst()
      .map(ScbCreditInfoDetail::getValue)
      .map(ScbCreditInfo::parseDecimal)
      .orElse(BigDecimal.ZERO);
  }

  public BigDecimal getValueByTypeName(String typeName) {
    return details.stream()
      .filter(detail -> detail.getTypeName().equals(typeName))
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

  public void calculateApprovedIncome(Long approvedIncomeId, Long approvedIncomeDictionaryId) {
    BigDecimal annualIncome = getValueByTypeName("annual_income");
    BigDecimal isRegularEmployee = getValueByTypeName("is_regular_employee");

    BigDecimal approvalIncome = isRegularEmployee.equals(BigDecimal.ONE) ? annualIncome : BigDecimalUtils.percent(annualIncome, NON_REGULAR_EMPLOYEE_APPROVAL_RATE);
    details.add(ScbCreditInfoDetail.builder()
      .id(approvedIncomeId)
      .scbCreditInfoId(id)
      .creditInfoDictionaryId(approvedIncomeDictionaryId)
      .typeName(ScbCreditInfoCalculationTypeName.APPROVED_INCOME.getTypeName())
      .description("인정 소득")
      .value(approvalIncome.toString())
      .build());
  }

}

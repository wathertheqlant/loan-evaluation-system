package io.watertheqlant.loan.evaluation.system.infrastructure.scb.type;

import lombok.Getter;

@Getter
public enum SeoulCreditBureauType {

  MAJOR_LOAN_USAGE_COUNT("major_loan_usage_count", "대부업 대출 이용 횟수"),
  CREDIT_RATING("credit_rating", "신용등급"),
  LOAN_DEFAULT_COUNT("loan_default_count", "대출 연체 횟수"),
  ANNUAL_INCOME("annual_income", "연소득"),
  IS_REGULAR_EMPLOYEE("is_regular_employee", "정규직 여부"),
  SHORT_TERM_CARD_LOAN_USAGE_COUNT("short_term_card_loan_usage_count", "단기카드대출 이용횟수"),
  LOAN_CLEAR_COUNT("loan_clear_count", "대출 완납 횟수"),
  CREDIT_CARD_ISSUE_COUNT("credit_card_issue_count", "신용카드 발행 회수");

  private final String code;
  private final String desc;
  SeoulCreditBureauType(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

}

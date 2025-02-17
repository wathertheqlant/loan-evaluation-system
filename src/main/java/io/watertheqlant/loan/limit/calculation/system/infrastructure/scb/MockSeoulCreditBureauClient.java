package io.watertheqlant.loan.limit.calculation.system.infrastructure.scb;

import io.watertheqlant.loan.limit.calculation.system.infrastructure.scb.dto.SeoulCreditBureauDetailInformation;
import io.watertheqlant.loan.limit.calculation.system.infrastructure.scb.dto.SeoulCreditBureauInformation;
import io.watertheqlant.loan.limit.calculation.system.infrastructure.scb.type.DataType;

import java.util.List;

public class MockSeoulCreditBureauClient implements SeoulCreditBureauClient {

  @Override
  public SeoulCreditBureauInformation getCreditInformation(String jumin) {
    switch (jumin) {
      case "9301011234567":
        return goodCase();
      case "9501011234567":
        return normalCase();
      case "8801011234567":
        return freelancerCase();
      case "8901011234567":
        return littleBitBadCase();
      case "9001011234567":
        return soBadCase();
      default:
        System.out.println("정보 조회 실패");
    }
    throw new RuntimeException("정보 조회 실패");
  }

  public SeoulCreditBureauInformation goodCase() {
    return  SeoulCreditBureauInformation.builder()
      .name("김햇살")
      .jumin("9301011234567")
      .details(List.of(
        SeoulCreditBureauDetailInformation.builder()
          .name("major_loan_usage_count")
          .description("대부업 대출 이용 횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_rating")
          .description("신용등급")
          .type(DataType.INTEGER)
          .value("2")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_default_count")
          .description("대출 연체 횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("annual_income")
          .description("연소득")
          .type(DataType.LONG)
          .value("50000000")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("is_regular_employee")
          .description("정규직 여부")
          .type(DataType.BOOLEAN)
          .value("true")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("short_term_card_loan_usage_count")
          .description("단기카드대출 이용횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_clear_count")
          .description("대출 완납 횟수")
          .type(DataType.INTEGER)
          .value("2")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_card_issue_count")
          .description("신용카드 발행 회수")
          .type(DataType.INTEGER)
          .value("5")
          .build()
      ))
      .build();
  }


  public SeoulCreditBureauInformation normalCase() {
    return  SeoulCreditBureauInformation.builder()
      .name("금화창")
      .jumin("9501011234567")
      .details(List.of(
        SeoulCreditBureauDetailInformation.builder()
          .name("major_loan_usage_count")
          .description("대부업 대출 이용 횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_rating")
          .description("신용등급")
          .type(DataType.INTEGER)
          .value("3")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_default_count")
          .description("대출 연체 횟수")
          .type(DataType.INTEGER)
          .value("1")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("annual_income")
          .description("연소득")
          .type(DataType.LONG)
          .value("45000000")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("is_regular_employee")
          .description("정규직 여부")
          .type(DataType.BOOLEAN)
          .value("true")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("short_term_card_loan_usage_count")
          .description("단기카드대출 이용횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_clear_count")
          .description("대출 완납 횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_card_issue_count")
          .description("신용카드 발행 회수")
          .type(DataType.INTEGER)
          .value("5")
          .build()
      ))
      .build();
  }


  public SeoulCreditBureauInformation freelancerCase() {
    return  SeoulCreditBureauInformation.builder()
      .name("장프리랜서")
      .jumin("8801011234567")
      .details(List.of(
        SeoulCreditBureauDetailInformation.builder()
          .name("major_loan_usage_count")
          .description("대부업 대출 이용 횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_rating")
          .description("신용등급")
          .type(DataType.INTEGER)
          .value("2")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_default_count")
          .description("대출 연체 횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("annual_income")
          .description("연소득")
          .type(DataType.LONG)
          .value("60000000")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("is_regular_employee")
          .description("정규직 여부")
          .type(DataType.BOOLEAN)
          .value("false")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("short_term_card_loan_usage_count")
          .description("단기카드대출 이용횟수")
          .type(DataType.INTEGER)
          .value("0")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_clear_count")
          .description("대출 완납 횟수")
          .type(DataType.INTEGER)
          .value("3")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_card_issue_count")
          .description("신용카드 발행 회수")
          .type(DataType.INTEGER)
          .value("5")
          .build()
      ))
      .build();
  }

  public SeoulCreditBureauInformation littleBitBadCase() {
    return  SeoulCreditBureauInformation.builder()
      .name("진먹구름")
      .jumin("8901011234567")
      .details(List.of(
        SeoulCreditBureauDetailInformation.builder()
          .name("major_loan_usage_count")
          .description("대부업 대출 이용 횟수")
          .type(DataType.INTEGER)
          .value("1")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_rating")
          .description("신용등급")
          .type(DataType.INTEGER)
          .value("7")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_default_count")
          .description("대출 연체 횟수")
          .type(DataType.INTEGER)
          .value("3")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("annual_income")
          .description("연소득")
          .type(DataType.LONG)
          .value("35000000")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("is_regular_employee")
          .description("정규직 여부")
          .type(DataType.BOOLEAN)
          .value("false")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("short_term_card_loan_usage_count")
          .description("단기카드대출 이용횟수")
          .type(DataType.INTEGER)
          .value("1")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_clear_count")
          .description("대출 완납 횟수")
          .type(DataType.INTEGER)
          .value("2")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_card_issue_count")
          .description("신용카드 발행 회수")
          .type(DataType.INTEGER)
          .value("5")
          .build()
      ))
      .build();
  }

  public SeoulCreditBureauInformation soBadCase() {
    return  SeoulCreditBureauInformation.builder()
      .name("김폭우")
      .jumin("9001011234567")
      .details(List.of(
        SeoulCreditBureauDetailInformation.builder()
          .name("major_loan_usage_count")
          .description("대부업 대출 이용 횟수")
          .type(DataType.INTEGER)
          .value("3")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_rating")
          .description("신용등급")
          .type(DataType.INTEGER)
          .value("8")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_default_count")
          .description("대출 연체 횟수")
          .type(DataType.INTEGER)
          .value("5")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("annual_income")
          .description("연소득")
          .type(DataType.LONG)
          .value("32000000")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("is_regular_employee")
          .description("정규직 여부")
          .type(DataType.BOOLEAN)
          .value("false")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("short_term_card_loan_usage_count")
          .description("단기카드대출 이용횟수")
          .type(DataType.INTEGER)
          .value("4")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("loan_clear_count")
          .description("대출 완납 횟수")
          .type(DataType.INTEGER)
          .value("2")
          .build(),
        SeoulCreditBureauDetailInformation.builder()
          .name("credit_card_issue_count")
          .description("신용카드 발행 회수")
          .type(DataType.INTEGER)
          .value("8")
          .build()
      ))
      .build();
  }

}

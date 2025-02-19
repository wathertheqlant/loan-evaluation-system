package io.watertheqlant.loan.evaluation.system.domain.type;

import lombok.Getter;

@Getter
public enum CreditBureauTypes {

  SCB("서울신용정보");

  private final String desc;
  CreditBureauTypes(String desc) {
    this.desc = desc;
  }

  public String desc() {
    return desc;
  }


}

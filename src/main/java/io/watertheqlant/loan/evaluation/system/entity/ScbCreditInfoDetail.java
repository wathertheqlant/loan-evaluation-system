package io.watertheqlant.loan.evaluation.system.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScbCreditInfoDetail {

  public static final String TABLE_NAME = "scb_credit_info_details";

  private Long id;
  private Long scbCreditInfoId;
  private Long creditInfoDictionaryId;
  private String typeName;
  private String description;

  private String value;

}

package io.watertheqlant.loan.evaluation.system.domain.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  public static final String TABLE_NAME = "customers";

  private Long id;
  private String customerName;
  private String customerJumin;

}

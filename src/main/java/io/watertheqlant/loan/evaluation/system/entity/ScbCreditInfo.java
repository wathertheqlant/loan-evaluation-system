package io.watertheqlant.loan.evaluation.system.entity;

import lombok.*;

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

}

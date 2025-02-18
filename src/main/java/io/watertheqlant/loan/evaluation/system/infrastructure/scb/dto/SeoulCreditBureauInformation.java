package io.watertheqlant.loan.evaluation.system.infrastructure.scb.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeoulCreditBureauInformation {

  private String name;
  private String jumin;
  private List<SeoulCreditBureauDetailInformation> details;


}

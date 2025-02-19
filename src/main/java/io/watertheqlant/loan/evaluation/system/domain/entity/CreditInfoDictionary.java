package io.watertheqlant.loan.evaluation.system.domain.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditInfoDictionary {

  private Long id;
  private String typeName;
  private String creditBureauName;
  private String type;
  private String description;
  private String example;

}

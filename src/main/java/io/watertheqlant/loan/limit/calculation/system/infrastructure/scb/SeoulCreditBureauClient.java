package io.watertheqlant.loan.limit.calculation.system.infrastructure.scb;

import io.watertheqlant.loan.limit.calculation.system.infrastructure.scb.dto.SeoulCreditBureauInformation;

public interface SeoulCreditBureauClient {

  SeoulCreditBureauInformation getCreditInformation(String jumin);

}

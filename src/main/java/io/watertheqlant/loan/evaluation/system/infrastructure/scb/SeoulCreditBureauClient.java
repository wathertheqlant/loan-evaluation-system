package io.watertheqlant.loan.evaluation.system.infrastructure.scb;

import io.watertheqlant.loan.evaluation.system.infrastructure.scb.dto.SeoulCreditBureauInformation;

public interface SeoulCreditBureauClient {

  SeoulCreditBureauInformation getCreditInformation(String jumin);

}

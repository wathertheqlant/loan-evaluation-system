package io.watertheqlant.loan.evaluation.system.domain.service;

import io.watertheqlant.loan.evaluation.system.domain.dao.CreditInfoDictionaryMapper;
import io.watertheqlant.loan.evaluation.system.domain.dao.ScbCreditInfoMapper;
import io.watertheqlant.loan.evaluation.system.domain.dao.SequenceMapper;
import io.watertheqlant.loan.evaluation.system.domain.entity.CreditInfoDictionary;
import io.watertheqlant.loan.evaluation.system.domain.entity.Customer;
import io.watertheqlant.loan.evaluation.system.domain.type.CreditBureauTypes;
import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfoDetail;
import io.watertheqlant.loan.evaluation.system.domain.entity.ScbCreditInfo;
import io.watertheqlant.loan.evaluation.system.infrastructure.scb.SeoulCreditBureauClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static io.watertheqlant.loan.evaluation.system.domain.type.ScbCreditInfoCalculationTypeName.APPROVED_INCOME;

@RequiredArgsConstructor
@Service
public class ScbCreditInfoService {

  private final ScbCreditInfoMapper scbCreditInfoMapper;
  private final CreditInfoDictionaryMapper creditInfoDictionaryMapper;
  private final SequenceMapper sequenceMapper;
  private final SeoulCreditBureauClient seoulCreditBureauClient;

  @Transactional
  public ScbCreditInfo queryAndSave(Customer customer) {
    LocalDate now = LocalDate.now();
    long scbCreditInfoId = sequenceMapper.get(ScbCreditInfo.TABLE_NAME);
    List<ScbCreditInfoDetail> scbCreditInfoDetails = seoulCreditBureauClient.getCreditInformation(customer.getCustomerJumin()).getDetails().stream()
      .map(e -> {
        Long id = sequenceMapper.get(ScbCreditInfoDetail.TABLE_NAME);
        CreditInfoDictionary creditInfoDictionary = creditInfoDictionaryMapper.findCreditInfoDictionaryByTypeName(e.getName(), CreditBureauTypes.SCB.name());
        return ScbCreditInfoDetail.builder()
          .id(id)
          .scbCreditInfoId(scbCreditInfoId)
          .creditInfoDictionaryId(creditInfoDictionary.getId())
          .typeName(creditInfoDictionary.getTypeName())
          .description(creditInfoDictionary.getDescription())
          .value(e.getValue())
          .build();
      }).collect(Collectors.toList());

    ScbCreditInfo scbCreditInfo = ScbCreditInfo.builder()
      .id(scbCreditInfoId)
        .customerId(customer.getId())
        .requestDate(now)
        .details(scbCreditInfoDetails)
        .build();
    CreditInfoDictionary creditInfoDictionary = creditInfoDictionaryMapper.findCreditInfoDictionaryByTypeName(APPROVED_INCOME.getTypeName(), CreditBureauTypes.SCB.name());
    Long approvedIncomeId = sequenceMapper.get(ScbCreditInfoDetail.TABLE_NAME);
    scbCreditInfo.calculateApprovedIncome(approvedIncomeId, creditInfoDictionary.getId());

    scbCreditInfoMapper.save(scbCreditInfo);
    return scbCreditInfo;
  }

}

package io.watertheqlant.loan.evaluation.system.dao;

import io.watertheqlant.loan.evaluation.system.entity.ScbCreditInfoDetail;
import io.watertheqlant.loan.evaluation.system.entity.ScbCreditInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@SpringBootTest
class ScbCreditInfoMapperTest {

  private ScbCreditInfoMapper scbCreditInfoMapper;

  @Test
  void save() {
    // given
    var now  = LocalDate.now();
    ScbCreditInfo scbCreditInfo = new ScbCreditInfo();
    scbCreditInfo.setCustomerId(1L);
    scbCreditInfo.setRequestDate(now);

    ScbCreditInfoDetail detail1 = new ScbCreditInfoDetail();
    detail1.setCreditInfoDictionaryId(1L);
    detail1.setValue("value");

    ScbCreditInfoDetail detail2 = new ScbCreditInfoDetail();
    detail2.setCreditInfoDictionaryId(2L);
    detail2.setValue("value");

    scbCreditInfo.getDetails().add(detail1);
    scbCreditInfo.getDetails().add(detail2);

    // when
    scbCreditInfoMapper.save(scbCreditInfo);

    // then





  }

}

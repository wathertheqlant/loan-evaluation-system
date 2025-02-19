package io.watertheqlant.loan.evaluation.system.domain.dao;

import io.watertheqlant.loan.evaluation.system.domain.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CustomerMapper {

  void save(Customer customer);

  Customer findByJumin(String jumin);

}

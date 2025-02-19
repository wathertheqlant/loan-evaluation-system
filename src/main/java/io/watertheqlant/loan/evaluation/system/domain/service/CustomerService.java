package io.watertheqlant.loan.evaluation.system.domain.service;

import io.watertheqlant.loan.evaluation.system.domain.dao.CustomerMapper;
import io.watertheqlant.loan.evaluation.system.domain.dao.SequenceMapper;
import io.watertheqlant.loan.evaluation.system.domain.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final SequenceMapper sequenceMapper;
  private final CustomerMapper customerMapper;

  @Transactional
  public Customer getOrSaveCustomer(String name, String jumin) {
    Optional<Customer> foundCustomer = Optional.ofNullable(customerMapper.findByJumin(jumin));
    return foundCustomer.orElseGet(() -> {
      Long id = sequenceMapper.get(Customer.TABLE_NAME);
      Customer customer = Customer.builder()
        .id(id)
        .customerName(name)
        .customerJumin(jumin)
        .build();
      customerMapper.save(customer);
      return customer;
    });
  };

}

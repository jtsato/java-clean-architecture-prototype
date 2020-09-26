package io.github.jtsato.bookstore.dataprovider.customer;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.RegisterCustomerGateway;
import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.mapper.CustomerMapper;
import io.github.jtsato.bookstore.dataprovider.customer.repository.CustomerRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterCustomerDataProvider implements RegisterCustomerGateway {

    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer execute(final Customer customer) {
        final CustomerEntity customerEntity = customerMapper.of(customer);
        return customerMapper.of(customerRepository.saveAndFlush(customerEntity));
    }
}

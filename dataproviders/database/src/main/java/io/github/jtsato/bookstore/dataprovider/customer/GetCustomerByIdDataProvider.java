package io.github.jtsato.bookstore.dataprovider.customer;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.GetCustomerByIdGateway;
import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.mapper.CustomerMapper;
import io.github.jtsato.bookstore.dataprovider.customer.repository.CustomerRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetCustomerByIdDataProvider implements GetCustomerByIdGateway {

    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> execute(final Long id) {
        final Optional<CustomerEntity> optional = customerRepository.findById(id);
        return optional.map(customerMapper::of);
    }
}

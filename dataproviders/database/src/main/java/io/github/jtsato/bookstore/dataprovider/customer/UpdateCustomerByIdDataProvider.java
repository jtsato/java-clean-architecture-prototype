package io.github.jtsato.bookstore.dataprovider.customer;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.UpdateCustomerByIdGateway;
import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.mapper.CustomerMapper;
import io.github.jtsato.bookstore.dataprovider.customer.repository.CustomerRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateCustomerByIdDataProvider implements UpdateCustomerByIdGateway {

    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> execute(final Customer customer) {

        final Optional<CustomerEntity> optional = customerRepository.findById(customer.getId());

        return optional.map(customerEntity -> updateCustomerEntity(customerEntity, customer));
    }

    private Customer updateCustomerEntity(final CustomerEntity customerEntity, final Customer customer) {
        customerEntity.setName(customer.getName());
        customerEntity.setAddress(customer.getAddress());
        return customerMapper.of(customerRepository.saveAndFlush(customerEntity));
    }
}

package io.github.jtsato.bookstore.dataprovider.customer;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.FindCustomersByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.domain.QCustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.mapper.CustomerMapper;
import io.github.jtsato.bookstore.dataprovider.customer.repository.CustomerRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindCustomersByIdsDataProvider implements FindCustomersByIdsGateway {

    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
    private final PageMapper<Customer, CustomerEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> execute(final List<Long> ids) {

        final BooleanExpression predicate = QCustomerEntity.customerEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<CustomerEntity> page = customerRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, customerMapper::of);
    }
}

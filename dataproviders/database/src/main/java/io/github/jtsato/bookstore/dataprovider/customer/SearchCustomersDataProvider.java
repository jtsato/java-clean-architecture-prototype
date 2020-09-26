package io.github.jtsato.bookstore.dataprovider.customer;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.SearchCustomersGateway;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.SearchCustomersParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.domain.QCustomerEntity;
import io.github.jtsato.bookstore.dataprovider.customer.mapper.CustomerMapper;
import io.github.jtsato.bookstore.dataprovider.customer.repository.CustomerRepository;
import io.github.jtsato.bookstore.dataprovider.customer.repository.SearchCustomersPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchCustomersDataProvider implements SearchCustomersGateway {
    
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
    private final PageMapper<Customer, CustomerEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> execute(final SearchCustomersParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchCustomersPredicateBuilder(QCustomerEntity.customerEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<CustomerEntity> page = customerRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, customerMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "name:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

package io.github.jtsato.bookstore.dataprovider.customer.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface CustomerMapper {

    Customer of(final CustomerEntity customerEntity);

    CustomerEntity of(final Customer customer);
}

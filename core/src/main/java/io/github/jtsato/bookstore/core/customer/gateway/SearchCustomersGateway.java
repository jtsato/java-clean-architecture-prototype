package io.github.jtsato.bookstore.core.customer.gateway;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.SearchCustomersParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchCustomersGateway {

    Page<Customer> execute(final SearchCustomersParameters parameters, final Integer page, final Integer size, final String orderBy);
}

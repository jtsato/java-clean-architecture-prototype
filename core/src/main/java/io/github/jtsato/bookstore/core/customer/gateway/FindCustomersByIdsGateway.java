package io.github.jtsato.bookstore.core.customer.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindCustomersByIdsGateway {

    Page<Customer> execute(final List<Long> ids);
}

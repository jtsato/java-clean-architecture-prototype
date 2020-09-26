package io.github.jtsato.bookstore.core.customer.gateway;

import io.github.jtsato.bookstore.core.customer.domain.Customer;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterCustomerGateway {

    Customer execute(final Customer customer);
}

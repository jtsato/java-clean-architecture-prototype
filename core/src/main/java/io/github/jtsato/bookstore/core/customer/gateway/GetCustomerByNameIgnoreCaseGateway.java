package io.github.jtsato.bookstore.core.customer.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.customer.domain.Customer;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetCustomerByNameIgnoreCaseGateway {

    Optional<Customer> execute(final String name);
}

package io.github.jtsato.bookstore.core.customer.usecase;

import io.github.jtsato.bookstore.core.customer.domain.Customer;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveCustomerByIdUseCase {

    Customer execute(final Long Id);
}

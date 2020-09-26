package io.github.jtsato.bookstore.core.customer.usecase;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.UpdateCustomerByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateCustomerByIdUseCase {

    Customer execute(final UpdateCustomerByIdParameters parameters);
}

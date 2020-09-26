package io.github.jtsato.bookstore.core.customer.usecase;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.RegisterCustomerParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterCustomerUseCase {

    Customer execute(final RegisterCustomerParameters parameters);
}

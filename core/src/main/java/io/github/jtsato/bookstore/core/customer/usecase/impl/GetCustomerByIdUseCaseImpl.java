package io.github.jtsato.bookstore.core.customer.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.GetCustomerByIdGateway;
import io.github.jtsato.bookstore.core.customer.usecase.GetCustomerByIdUseCase;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */

/**
 * @author Jorge Takeshi Sato
 */

@Named
@RequiredArgsConstructor
public class GetCustomerByIdUseCaseImpl implements GetCustomerByIdUseCase {

    private final GetCustomerByIdGateway getCustomerByIdGateway;

    @Override
    public Customer execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.customer.id.null");
        }
        final Optional<Customer> optional = getCustomerByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.customer.id.notfound", String.valueOf(id)));
    }
}

package io.github.jtsato.bookstore.core.customer.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.GetCustomerByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.customer.gateway.GetCustomerByAddressIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.customer.gateway.RegisterCustomerGateway;
import io.github.jtsato.bookstore.core.customer.usecase.RegisterCustomerUseCase;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.RegisterCustomerParameters;
import io.github.jtsato.bookstore.core.exception.UniqueConstraintException;
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
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final RegisterCustomerGateway registerCustomerGateway;

    private final GetCustomerByNameIgnoreCaseGateway getCustomerByNameIgnoreCaseGateway;

    private final GetCustomerByAddressIgnoreCaseGateway getCustomerByAddressIgnoreCaseGateway;

    @Override
    public Customer execute(final RegisterCustomerParameters parameters) {

        checkDuplicatedNameViolation(parameters.getName());

        checkDuplicatedAddressViolation(parameters.getAddress());

        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String address = StringUtils.stripToEmpty(parameters.getAddress());

        final Customer customer = new Customer(null,
                                               name,
                                               address);

        return registerCustomerGateway.execute(customer);
    }

    private void checkDuplicatedNameViolation(final String name) {
        final Optional<Customer> optional = getCustomerByNameIgnoreCaseGateway.execute(name);
        optional.ifPresent(this::throwUniqueConstraintExceptionForName);
    }

    private void throwUniqueConstraintExceptionForName(final Customer customer) {
        throw new UniqueConstraintException("validation.customer.name.already.exists", customer.getName());
    }

    private void checkDuplicatedAddressViolation(final String address) {
        final Optional<Customer> optional = getCustomerByAddressIgnoreCaseGateway.execute(address);
        optional.ifPresent(this::throwUniqueConstraintExceptionForAddress);
    }

    private void throwUniqueConstraintExceptionForAddress(final Customer customer) {
        throw new UniqueConstraintException("validation.customer.address.already.exists", customer.getAddress());
    }
}

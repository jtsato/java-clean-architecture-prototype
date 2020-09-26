package io.github.jtsato.bookstore.core.customer.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.GetCustomerByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.customer.gateway.GetCustomerByAddressIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.customer.gateway.UpdateCustomerByIdGateway;
import io.github.jtsato.bookstore.core.customer.usecase.UpdateCustomerByIdUseCase;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.UpdateCustomerByIdParameters;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
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
public class UpdateCustomerByIdUseCaseImpl implements UpdateCustomerByIdUseCase {

    private final UpdateCustomerByIdGateway updateCustomerByIdGateway;

    private final GetCustomerByNameIgnoreCaseGateway getCustomerByNameIgnoreCaseGateway;

    private final GetCustomerByAddressIgnoreCaseGateway getCustomerByAddressIgnoreCaseGateway;

    @Override
    public Customer execute(final UpdateCustomerByIdParameters parameters) {

        checkDuplicatedNameViolation(parameters.getId(), parameters.getName());

        checkDuplicatedAddressViolation(parameters.getId(), parameters.getAddress());

        final Long id = parameters.getId();
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String address = StringUtils.stripToEmpty(parameters.getAddress());

        final Customer customer = new Customer(id ,
                                               name,
                                               address);

        final Optional<Customer> optional = updateCustomerByIdGateway.execute(customer);
        return optional.orElseThrow(() -> new NotFoundException("validation.customer.id.notfound", String.valueOf(parameters.getId())));
    }

    private void checkDuplicatedNameViolation(final Long id, final String name) {

        final Optional<Customer> optional = getCustomerByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final Customer customer = optional.get();
        if (!customer.getId().equals(id)) {
            throw new UniqueConstraintException("validation.customer.name.already.exists", customer.getName());
        }
    }

    private void checkDuplicatedAddressViolation(final Long id, final String address) {

        final Optional<Customer> optional = getCustomerByAddressIgnoreCaseGateway.execute(address);

        if (optional.isEmpty()) {
            return;
        }

        final Customer customer = optional.get();
        if (!customer.getId().equals(id)) {
            throw new UniqueConstraintException("validation.customer.address.already.exists", customer.getAddress());
        }
    }
}

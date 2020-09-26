package io.github.jtsato.bookstore.core.customer.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.gateway.SearchCustomersGateway;
import io.github.jtsato.bookstore.core.customer.usecase.SearchCustomersUseCase;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.SearchCustomersParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
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
public class SearchCustomersUseCaseImpl implements SearchCustomersUseCase {

    private final SearchCustomersGateway searchCustomersGateway;

    @Override
    public Page<Customer> execute(final SearchCustomersParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchCustomersGateway.execute(parameters, page, size, orderBy);
    }
}

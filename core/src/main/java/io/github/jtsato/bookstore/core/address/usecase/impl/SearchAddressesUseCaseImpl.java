package io.github.jtsato.bookstore.core.address.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.SearchAddressesGateway;
import io.github.jtsato.bookstore.core.address.usecase.SearchAddressesUseCase;
import io.github.jtsato.bookstore.core.address.usecase.parameter.SearchAddressesParameters;
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
public class SearchAddressesUseCaseImpl implements SearchAddressesUseCase {

    private final SearchAddressesGateway searchAddressesGateway;

    @Override
    public Page<Address> execute(final SearchAddressesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchAddressesGateway.execute(parameters, page, size, orderBy);
    }
}

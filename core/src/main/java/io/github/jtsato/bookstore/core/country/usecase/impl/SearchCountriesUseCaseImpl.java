package io.github.jtsato.bookstore.core.country.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.SearchCountriesGateway;
import io.github.jtsato.bookstore.core.country.usecase.SearchCountriesUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
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
public class SearchCountriesUseCaseImpl implements SearchCountriesUseCase {

    private final SearchCountriesGateway searchCountriesGateway;

    @Override
    public Page<Country> execute(final SearchCountriesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchCountriesGateway.execute(parameters, page, size, orderBy);
    }
}

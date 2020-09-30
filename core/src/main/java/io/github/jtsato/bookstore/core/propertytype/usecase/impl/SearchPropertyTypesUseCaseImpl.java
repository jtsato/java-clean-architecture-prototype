package io.github.jtsato.bookstore.core.propertytype.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.SearchPropertyTypesGateway;
import io.github.jtsato.bookstore.core.propertytype.usecase.SearchPropertyTypesUseCase;
import io.github.jtsato.bookstore.core.propertytype.usecase.parameter.SearchPropertyTypesParameters;
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
public class SearchPropertyTypesUseCaseImpl implements SearchPropertyTypesUseCase {

    private final SearchPropertyTypesGateway searchPropertyTypesGateway;

    @Override
    public Page<PropertyType> execute(final SearchPropertyTypesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchPropertyTypesGateway.execute(parameters, page, size, orderBy);
    }
}

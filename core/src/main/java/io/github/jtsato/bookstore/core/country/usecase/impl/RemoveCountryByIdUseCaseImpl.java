package io.github.jtsato.bookstore.core.country.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.RemoveCountryByIdGateway;
import io.github.jtsato.bookstore.core.country.usecase.RemoveCountryByIdUseCase;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.SearchPropertyTypesByCountryIdGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.ParentConstraintException;
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
public class RemoveCountryByIdUseCaseImpl implements RemoveCountryByIdUseCase {

    private final RemoveCountryByIdGateway removeCountryByIdGateway;

    private final SearchPropertyTypesByCountryIdGateway searchPropertyTypesByCountryIdGateway;

    @Override
    public Country execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.country.id.null");
        }

        avoidRemovingCountryWithPropertyTypes(id);

        final Optional<Country> optional = removeCountryByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingCountryWithPropertyTypes(final Long id) {

        final Page<PropertyType> pageOfPropertyTypes = searchPropertyTypesByCountryIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfPropertyTypes.getContent())) {
            throw new ParentConstraintException("validation.country.with.property.types.removal");
        }
    }
}

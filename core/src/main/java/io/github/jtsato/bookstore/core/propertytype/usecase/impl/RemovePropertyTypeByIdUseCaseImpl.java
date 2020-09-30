package io.github.jtsato.bookstore.core.propertytype.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.RemovePropertyTypeByIdGateway;
import io.github.jtsato.bookstore.core.propertytype.usecase.RemovePropertyTypeByIdUseCase;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.SearchAddressesByPropertyTypeIdGateway;
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
public class RemovePropertyTypeByIdUseCaseImpl implements RemovePropertyTypeByIdUseCase {

    private final RemovePropertyTypeByIdGateway removePropertyTypeByIdGateway;

    private final SearchAddressesByPropertyTypeIdGateway searchAddressesByPropertyTypeIdGateway;

    @Override
    public PropertyType execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.property.type.id.null");
        }

        avoidRemovingPropertyTypeWithAddresses(id);

        final Optional<PropertyType> optional = removePropertyTypeByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.property.type.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingPropertyTypeWithAddresses(final Long id) {

        final Page<Address> pageOfAddresses = searchAddressesByPropertyTypeIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfAddresses.getContent())) {
            throw new ParentConstraintException("validation.property.type.with.addresses.removal");
        }
    }
}

package io.github.jtsato.bookstore.core.propertytype.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.GetPropertyTypeByIdGateway;
import io.github.jtsato.bookstore.core.propertytype.usecase.GetPropertyTypeByIdUseCase;
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
public class GetPropertyTypeByIdUseCaseImpl implements GetPropertyTypeByIdUseCase {

    private final GetPropertyTypeByIdGateway getPropertyTypeByIdGateway;

    @Override
    public PropertyType execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.property.type.id.null");
        }
        final Optional<PropertyType> optional = getPropertyTypeByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.property.type.id.notfound", String.valueOf(id)));
    }
}

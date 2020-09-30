package io.github.jtsato.bookstore.core.propertytype.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.UpdatePropertyTypeByIdGateway;
import io.github.jtsato.bookstore.core.propertytype.usecase.UpdatePropertyTypeByIdUseCase;
import io.github.jtsato.bookstore.core.propertytype.usecase.parameter.UpdatePropertyTypeByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
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
public class UpdatePropertyTypeByIdUseCaseImpl implements UpdatePropertyTypeByIdUseCase {

    private final UpdatePropertyTypeByIdGateway updatePropertyTypeByIdGateway;

    private final GetCountryByIdGateway getCountryByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public PropertyType execute(final UpdatePropertyTypeByIdParameters parameters) {
        final Country country = getCountryAndValidate(parameters.getCountryId());

        final Long id = parameters.getId();
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final PropertyType propertyType = new PropertyType(id ,
                                                           country,
                                                           description,
                                                           null,
                                                           lastModifiedDateTime);

        final Optional<PropertyType> optional = updatePropertyTypeByIdGateway.execute(propertyType);
        return optional.orElseThrow(() -> new NotFoundException("validation.property.type.id.notfound", String.valueOf(parameters.getId())));
    }

    private Country getCountryAndValidate(final Long countryId) {
        final Optional<Country> optional = getCountryByIdGateway.execute(countryId);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(countryId)));
    }
}

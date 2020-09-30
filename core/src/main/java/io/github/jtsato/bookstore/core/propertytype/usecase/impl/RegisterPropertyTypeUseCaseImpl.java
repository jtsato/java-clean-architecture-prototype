package io.github.jtsato.bookstore.core.propertytype.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.RegisterPropertyTypeGateway;
import io.github.jtsato.bookstore.core.propertytype.usecase.RegisterPropertyTypeUseCase;
import io.github.jtsato.bookstore.core.propertytype.usecase.parameter.RegisterPropertyTypeParameters;
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
public class RegisterPropertyTypeUseCaseImpl implements RegisterPropertyTypeUseCase {

    private final RegisterPropertyTypeGateway registerPropertyTypeGateway;

    private final GetCountryByIdGateway getCountryByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public PropertyType execute(final RegisterPropertyTypeParameters parameters) {

        final Country country = getCountryAndValidate(parameters.getCountryId());

        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final PropertyType propertyType = new PropertyType(null,
                                                           country,
                                                           description,
                                                           createdDateTime,
                                                           lastModifiedDateTime);

        return registerPropertyTypeGateway.execute(propertyType);
    }

    private Country getCountryAndValidate(final Long countryId) {
        final Optional<Country> optional = getCountryByIdGateway.execute(countryId);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(countryId)));
    }
}

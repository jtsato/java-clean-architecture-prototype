package io.github.jtsato.bookstore.core.maritalstatus.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.gateway.RegisterMaritalStatusGateway;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.RegisterMaritalStatusUseCase;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter.RegisterMaritalStatusParameters;
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
public class RegisterMaritalStatusUseCaseImpl implements RegisterMaritalStatusUseCase {

    private final RegisterMaritalStatusGateway registerMaritalStatusGateway;

    private final GetCountryByIdGateway getCountryByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public MaritalStatus execute(final RegisterMaritalStatusParameters parameters) {

        final Country country = getCountryAndValidate(parameters.getCountryId());

        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final MaritalStatus maritalStatus = new MaritalStatus(null,
                                                              country,
                                                              description,
                                                              createdDateTime,
                                                              lastModifiedDateTime);

        return registerMaritalStatusGateway.execute(maritalStatus);
    }

    private Country getCountryAndValidate(final Long countryId) {
        final Optional<Country> optional = getCountryByIdGateway.execute(countryId);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(countryId)));
    }
}

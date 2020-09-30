package io.github.jtsato.bookstore.core.maritalstatus.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.gateway.UpdateMaritalStatusByIdGateway;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.UpdateMaritalStatusByIdUseCase;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter.UpdateMaritalStatusByIdParameters;
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
public class UpdateMaritalStatusByIdUseCaseImpl implements UpdateMaritalStatusByIdUseCase {

    private final UpdateMaritalStatusByIdGateway updateMaritalStatusByIdGateway;

    private final GetCountryByIdGateway getCountryByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public MaritalStatus execute(final UpdateMaritalStatusByIdParameters parameters) {
        final Country country = getCountryAndValidate(parameters.getCountryId());

        final Long id = parameters.getId();
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final MaritalStatus maritalStatus = new MaritalStatus(id ,
                                                              country,
                                                              description,
                                                              null,
                                                              lastModifiedDateTime);

        final Optional<MaritalStatus> optional = updateMaritalStatusByIdGateway.execute(maritalStatus);
        return optional.orElseThrow(() -> new NotFoundException("validation.marital.status.id.notfound", String.valueOf(parameters.getId())));
    }

    private Country getCountryAndValidate(final Long countryId) {
        final Optional<Country> optional = getCountryByIdGateway.execute(countryId);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(countryId)));
    }
}

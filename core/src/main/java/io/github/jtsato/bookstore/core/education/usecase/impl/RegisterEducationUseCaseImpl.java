package io.github.jtsato.bookstore.core.education.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.gateway.RegisterEducationGateway;
import io.github.jtsato.bookstore.core.education.usecase.RegisterEducationUseCase;
import io.github.jtsato.bookstore.core.education.usecase.parameter.RegisterEducationParameters;
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
public class RegisterEducationUseCaseImpl implements RegisterEducationUseCase {

    private final RegisterEducationGateway registerEducationGateway;

    private final GetCountryByIdGateway getCountryByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Education execute(final RegisterEducationParameters parameters) {

        final Country country = getCountryAndValidate(parameters.getCountryId());

        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final Education education = new Education(null,
                                                  country,
                                                  description,
                                                  createdDateTime,
                                                  lastModifiedDateTime);

        return registerEducationGateway.execute(education);
    }

    private Country getCountryAndValidate(final Long countryId) {
        final Optional<Country> optional = getCountryByIdGateway.execute(countryId);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(countryId)));
    }
}

package io.github.jtsato.bookstore.core.education.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.gateway.UpdateEducationByIdGateway;
import io.github.jtsato.bookstore.core.education.usecase.UpdateEducationByIdUseCase;
import io.github.jtsato.bookstore.core.education.usecase.parameter.UpdateEducationByIdParameters;
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
public class UpdateEducationByIdUseCaseImpl implements UpdateEducationByIdUseCase {

    private final UpdateEducationByIdGateway updateEducationByIdGateway;

    private final GetCountryByIdGateway getCountryByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Education execute(final UpdateEducationByIdParameters parameters) {
        final Country country = getCountryAndValidate(parameters.getCountryId());

        final Long id = parameters.getId();
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Education education = new Education(id ,
                                                  country,
                                                  description,
                                                  null,
                                                  lastModifiedDateTime);

        final Optional<Education> optional = updateEducationByIdGateway.execute(education);
        return optional.orElseThrow(() -> new NotFoundException("validation.education.id.notfound", String.valueOf(parameters.getId())));
    }

    private Country getCountryAndValidate(final Long countryId) {
        final Optional<Country> optional = getCountryByIdGateway.execute(countryId);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(countryId)));
    }
}

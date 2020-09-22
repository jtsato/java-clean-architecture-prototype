package io.github.jtsato.bookstore.core.country.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.country.gateway.UpdateCountryByIdGateway;
import io.github.jtsato.bookstore.core.country.usecase.UpdateCountryByIdUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.UpdateCountryByIdParameters;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.UniqueConstraintException;
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
public class UpdateCountryByIdUseCaseImpl implements UpdateCountryByIdUseCase {

    private final UpdateCountryByIdGateway updateCountryByIdGateway;

    private final GetCountryByNameIgnoreCaseGateway getCountryByNameIgnoreCaseGateway;

    @Override
    public Country execute(final UpdateCountryByIdParameters parameters) {

        checkDuplicatedNameViolation(parameters.getId(), parameters.getName());

        final Long id = parameters.getId();
        final String name = StringUtils.stripToEmpty(parameters.getName());

        final Country country = new Country(id ,
                                            name);

        final Optional<Country> optional = updateCountryByIdGateway.execute(country);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(parameters.getId())));
    }

    private void checkDuplicatedNameViolation(final Long id, final String name) {

        final Optional<Country> optional = getCountryByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final Country country = optional.get();
        if (!country.getId().equals(id)) {
            throw new UniqueConstraintException("validation.country.name.already.exists", country.getName());
        }
    }
}

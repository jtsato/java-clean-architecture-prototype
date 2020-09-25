package io.github.jtsato.bookstore.core.country.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.country.gateway.RegisterCountryGateway;
import io.github.jtsato.bookstore.core.country.usecase.RegisterCountryUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.RegisterCountryParameters;
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
public class RegisterCountryUseCaseImpl implements RegisterCountryUseCase {

    private final RegisterCountryGateway registerCountryGateway;

    private final GetCountryByNameIgnoreCaseGateway getCountryByNameIgnoreCaseGateway;

    @Override
    public Country execute(final RegisterCountryParameters parameters) {

        checkDuplicatedNameViolation(parameters.getName());

        final String name = StringUtils.stripToEmpty(parameters.getName());

        final Country country = new Country(null,
                                            name);

        return registerCountryGateway.execute(country);
    }

    private void checkDuplicatedNameViolation(final String name) {
        final Optional<Country> optional = getCountryByNameIgnoreCaseGateway.execute(name);
        optional.ifPresent(this::throwUniqueConstraintExceptionForName);
    }

    private void throwUniqueConstraintExceptionForName(final Country country) {
        throw new UniqueConstraintException("validation.country.name.already.exists", country.getName());
    }
}

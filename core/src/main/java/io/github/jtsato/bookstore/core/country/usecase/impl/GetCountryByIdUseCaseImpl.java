package io.github.jtsato.bookstore.core.country.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.core.country.usecase.GetCountryByIdUseCase;
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
public class GetCountryByIdUseCaseImpl implements GetCountryByIdUseCase {

    private final GetCountryByIdGateway getCountryByIdGateway;

    @Override
    public Country execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.country.id.null");
        }
        final Optional<Country> optional = getCountryByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(id)));
    }
}

package io.github.jtsato.bookstore.core.country.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.country.domain.Country;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetCountryByIdGateway {

    Optional<Country> execute(final Long Id);
}
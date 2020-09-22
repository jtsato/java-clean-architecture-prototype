package io.github.jtsato.bookstore.core.country.gateway;

import io.github.jtsato.bookstore.core.country.domain.Country;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterCountryGateway {

    Country execute(final Country country);
}

package io.github.jtsato.bookstore.core.country.usecase;

import io.github.jtsato.bookstore.core.country.domain.Country;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveCountryByIdUseCase {

    Country execute(final Long Id);
}

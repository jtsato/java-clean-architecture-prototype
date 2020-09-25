package io.github.jtsato.bookstore.core.country.usecase;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.parameter.UpdateCountryByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateCountryByIdUseCase {

    Country execute(final UpdateCountryByIdParameters parameters);
}

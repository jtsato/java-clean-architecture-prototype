package io.github.jtsato.bookstore.core.country.usecase;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.parameter.RegisterCountryParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterCountryUseCase {

    Country execute(final RegisterCountryParameters parameters);
}

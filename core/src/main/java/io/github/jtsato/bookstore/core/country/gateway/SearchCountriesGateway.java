package io.github.jtsato.bookstore.core.country.gateway;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchCountriesGateway {

    Page<Country> execute(final SearchCountriesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

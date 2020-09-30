package io.github.jtsato.bookstore.core.country.gateway;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchCountriesByLanguageIdGateway {

    Page<Country> execute(final Long languageId, final Integer pageNumber, final Integer size, final String orderBy);
}

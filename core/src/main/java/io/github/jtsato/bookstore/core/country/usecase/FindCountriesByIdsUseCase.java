package io.github.jtsato.bookstore.core.country.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindCountriesByIdsUseCase {

    Page<Country> execute(final List<Long> ids);
}

package io.github.jtsato.bookstore.core.country.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindCountriesByIdsGateway {

    Page<Country> execute(final List<Long> ids);
}

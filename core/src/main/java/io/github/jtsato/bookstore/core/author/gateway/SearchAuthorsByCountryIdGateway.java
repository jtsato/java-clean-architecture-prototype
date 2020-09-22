package io.github.jtsato.bookstore.core.author.gateway;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchAuthorsByCountryIdGateway {

    Page<Author> execute(final Long countryId, final Integer pageNumber, final Integer size, final String orderBy);
}

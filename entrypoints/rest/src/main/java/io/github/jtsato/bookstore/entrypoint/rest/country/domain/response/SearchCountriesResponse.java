package io.github.jtsato.bookstore.entrypoint.rest.country.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchCountriesResponse extends PageImpl<SearchCountriesInnerResponse> {

    public SearchCountriesResponse(final List<SearchCountriesInnerResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

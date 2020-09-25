package io.github.jtsato.bookstore.entrypoint.rest.country.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchCountriesWrapperResponse extends PageImpl<SearchCountriesResponse> {

    public SearchCountriesWrapperResponse(final List<SearchCountriesResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

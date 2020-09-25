package io.github.jtsato.bookstore.entrypoint.rest.country.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindCountriesByIdsWrapperResponse extends PageImpl<FindCountriesByIdsResponse> {

    public FindCountriesByIdsWrapperResponse(final List<FindCountriesByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

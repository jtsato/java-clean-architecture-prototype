package io.github.jtsato.bookstore.entrypoint.rest.address.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchAddressesWrapperResponse extends PageImpl<SearchAddressesResponse> {

    public SearchAddressesWrapperResponse(final List<SearchAddressesResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchCustomersWrapperResponse extends PageImpl<SearchCustomersResponse> {

    public SearchCustomersWrapperResponse(final List<SearchCustomersResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

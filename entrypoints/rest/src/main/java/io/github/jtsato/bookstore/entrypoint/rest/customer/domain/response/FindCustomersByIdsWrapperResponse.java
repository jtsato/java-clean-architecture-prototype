package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindCustomersByIdsWrapperResponse extends PageImpl<FindCustomersByIdsResponse> {

    public FindCustomersByIdsWrapperResponse(final List<FindCustomersByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

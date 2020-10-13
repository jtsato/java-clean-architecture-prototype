package io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindBalancesByIdsWrapperResponse extends PageImpl<FindBalancesByIdsResponse> {

    public FindBalancesByIdsWrapperResponse(final List<FindBalancesByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

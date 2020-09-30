package io.github.jtsato.bookstore.entrypoint.rest.address.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindAddressesByIdsWrapperResponse extends PageImpl<FindAddressesByIdsResponse> {

    public FindAddressesByIdsWrapperResponse(final List<FindAddressesByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

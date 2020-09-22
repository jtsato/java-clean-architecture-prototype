package io.github.jtsato.bookstore.entrypoint.rest.author.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindAuthorsByIdsWrapperResponse extends PageImpl<FindAuthorsByIdsResponse> {

    public FindAuthorsByIdsWrapperResponse(final List<FindAuthorsByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

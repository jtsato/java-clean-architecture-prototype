package io.github.jtsato.bookstore.entrypoint.rest.document.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindDocumentsByIdsWrapperResponse extends PageImpl<FindDocumentsByIdsResponse> {

    public FindDocumentsByIdsWrapperResponse(final List<FindDocumentsByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

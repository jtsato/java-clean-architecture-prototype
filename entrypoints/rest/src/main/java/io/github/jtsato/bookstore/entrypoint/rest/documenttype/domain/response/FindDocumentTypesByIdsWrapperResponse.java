package io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindDocumentTypesByIdsWrapperResponse extends PageImpl<FindDocumentTypesByIdsResponse> {

    public FindDocumentTypesByIdsWrapperResponse(final List<FindDocumentTypesByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

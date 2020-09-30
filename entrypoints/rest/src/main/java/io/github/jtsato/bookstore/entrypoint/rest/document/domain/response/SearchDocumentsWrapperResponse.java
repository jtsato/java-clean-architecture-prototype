package io.github.jtsato.bookstore.entrypoint.rest.document.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchDocumentsWrapperResponse extends PageImpl<SearchDocumentsResponse> {

    public SearchDocumentsWrapperResponse(final List<SearchDocumentsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

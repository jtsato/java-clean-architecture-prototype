package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchBookDocumentsWrapperResponse extends PageImpl<SearchBookDocumentsResponse> {

    public SearchBookDocumentsWrapperResponse(final List<SearchBookDocumentsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

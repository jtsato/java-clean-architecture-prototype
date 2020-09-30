package io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchDocumentTypesWrapperResponse extends PageImpl<SearchDocumentTypesResponse> {

    public SearchDocumentTypesWrapperResponse(final List<SearchDocumentTypesResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

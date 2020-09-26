package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindBookDocumentsByXxKeysWrapperResponse extends PageImpl<FindBookDocumentsByXxKeysResponse> {

    public FindBookDocumentsByXxKeysWrapperResponse(final List<FindBookDocumentsByXxKeysResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

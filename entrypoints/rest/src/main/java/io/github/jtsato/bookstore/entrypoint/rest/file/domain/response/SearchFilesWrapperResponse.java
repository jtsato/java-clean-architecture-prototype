package io.github.jtsato.bookstore.entrypoint.rest.file.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchFilesWrapperResponse extends PageImpl<SearchFilesResponse> {

    public SearchFilesWrapperResponse(final List<SearchFilesResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

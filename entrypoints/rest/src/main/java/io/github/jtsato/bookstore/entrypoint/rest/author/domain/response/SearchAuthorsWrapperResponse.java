package io.github.jtsato.bookstore.entrypoint.rest.author.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchAuthorsWrapperResponse extends PageImpl<SearchAuthorsResponse> {

    public SearchAuthorsWrapperResponse(final List<SearchAuthorsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

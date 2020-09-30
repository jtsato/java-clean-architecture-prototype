package io.github.jtsato.bookstore.entrypoint.rest.file.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindFilesByIdsWrapperResponse extends PageImpl<FindFilesByIdsResponse> {

    public FindFilesByIdsWrapperResponse(final List<FindFilesByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

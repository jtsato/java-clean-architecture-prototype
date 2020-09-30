package io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindLeadsByIdsWrapperResponse extends PageImpl<FindLeadsByIdsResponse> {

    public FindLeadsByIdsWrapperResponse(final List<FindLeadsByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

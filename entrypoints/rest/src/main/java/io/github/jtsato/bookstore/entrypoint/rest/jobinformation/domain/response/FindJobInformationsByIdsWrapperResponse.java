package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class FindJobInformationsByIdsWrapperResponse extends PageImpl<FindJobInformationsByIdsResponse> {

    public FindJobInformationsByIdsWrapperResponse(final List<FindJobInformationsByIdsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

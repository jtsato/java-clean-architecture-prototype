package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response;

import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.PageImpl;
import io.github.jtsato.bookstore.core.common.paging.Pageable;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchJobInformationsWrapperResponse extends PageImpl<SearchJobInformationsResponse> {

    public SearchJobInformationsWrapperResponse(final List<SearchJobInformationsResponse> content, final Pageable pageable) {
        super(content, pageable);
    }
}

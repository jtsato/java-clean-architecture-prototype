package io.github.jtsato.bookstore.core.document.gateway;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.parameter.SearchDocumentsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchDocumentsGateway {

    Page<Document> execute(final SearchDocumentsParameters parameters, final Integer page, final Integer size, final String orderBy);
}

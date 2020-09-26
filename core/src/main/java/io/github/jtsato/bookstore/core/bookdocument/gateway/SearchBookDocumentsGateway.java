package io.github.jtsato.bookstore.core.bookdocument.gateway;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.SearchBookDocumentsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchBookDocumentsGateway {

    Page<BookDocument> execute(final SearchBookDocumentsParameters parameters, final Integer page, final Integer size, final String orderBy);
}

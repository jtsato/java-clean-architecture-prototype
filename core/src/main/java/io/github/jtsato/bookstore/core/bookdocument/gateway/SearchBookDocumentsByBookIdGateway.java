package io.github.jtsato.bookstore.core.bookdocument.gateway;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchBookDocumentsByBookIdGateway {

    Page<BookDocument> execute(final Long bookId, final Integer pageNumber, final Integer size, final String orderBy);
}

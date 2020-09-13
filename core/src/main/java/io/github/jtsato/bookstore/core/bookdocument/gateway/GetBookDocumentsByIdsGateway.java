package io.github.jtsato.bookstore.core.bookdocument.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetBookDocumentsByIdsGateway {

    Page<BookDocument> execute(final List<Long> ids);
}
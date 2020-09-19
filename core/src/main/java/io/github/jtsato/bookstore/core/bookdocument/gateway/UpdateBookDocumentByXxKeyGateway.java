package io.github.jtsato.bookstore.core.bookdocument.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateBookDocumentByXxKeyGateway {

    Optional<BookDocument> execute(final BookDocument bookDocument);
}

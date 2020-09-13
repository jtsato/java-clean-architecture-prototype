package io.github.jtsato.bookstore.core.bookdocument.gateway;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterBookDocumentGateway {

    BookDocument execute(final BookDocument bookDocument);
}

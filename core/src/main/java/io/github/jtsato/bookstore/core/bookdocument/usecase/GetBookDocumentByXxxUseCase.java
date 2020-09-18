package io.github.jtsato.bookstore.core.bookdocument.usecase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetBookDocumentByXxxUseCase {

    BookDocument execute(final Long Xxx);
}

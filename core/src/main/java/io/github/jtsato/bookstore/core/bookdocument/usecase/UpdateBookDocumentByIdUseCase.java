package io.github.jtsato.bookstore.core.bookdocument.usecase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.UpdateBookDocumentByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateBookDocumentByIdUseCase {

    BookDocument execute(final UpdateBookDocumentByIdParameters parameters);
}

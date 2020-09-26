package io.github.jtsato.bookstore.core.bookdocument.usecase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.RegisterBookDocumentParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterBookDocumentUseCase {

    BookDocument execute(final RegisterBookDocumentParameters parameters);
}

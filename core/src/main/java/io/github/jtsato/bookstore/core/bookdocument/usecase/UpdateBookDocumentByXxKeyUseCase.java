package io.github.jtsato.bookstore.core.bookdocument.usecase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.UpdateBookDocumentByXxKeyParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateBookDocumentByXxKeyUseCase {

    BookDocument execute(final UpdateBookDocumentByXxKeyParameters parameters);
}

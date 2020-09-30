package io.github.jtsato.bookstore.core.document.usecase;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.parameter.RegisterDocumentParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterDocumentUseCase {

    Document execute(final RegisterDocumentParameters parameters);
}

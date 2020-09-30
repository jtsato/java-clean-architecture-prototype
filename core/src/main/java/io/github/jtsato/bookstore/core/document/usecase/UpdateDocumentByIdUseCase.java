package io.github.jtsato.bookstore.core.document.usecase;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.parameter.UpdateDocumentByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateDocumentByIdUseCase {

    Document execute(final UpdateDocumentByIdParameters parameters);
}

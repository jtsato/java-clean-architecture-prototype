package io.github.jtsato.bookstore.core.documenttype.usecase;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.UpdateDocumentTypeByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateDocumentTypeByIdUseCase {

    DocumentType execute(final UpdateDocumentTypeByIdParameters parameters);
}

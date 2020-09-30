package io.github.jtsato.bookstore.core.documenttype.usecase;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveDocumentTypeByIdUseCase {

    DocumentType execute(final Long Id);
}

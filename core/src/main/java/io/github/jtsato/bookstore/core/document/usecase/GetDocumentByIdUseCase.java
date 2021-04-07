package io.github.jtsato.bookstore.core.document.usecase;

import io.github.jtsato.bookstore.core.document.domain.Document;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetDocumentByIdUseCase {

    Document execute(final Long Id);
}
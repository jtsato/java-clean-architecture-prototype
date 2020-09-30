package io.github.jtsato.bookstore.core.documenttype.usecase;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.RegisterDocumentTypeParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterDocumentTypeUseCase {

    DocumentType execute(final RegisterDocumentTypeParameters parameters);
}

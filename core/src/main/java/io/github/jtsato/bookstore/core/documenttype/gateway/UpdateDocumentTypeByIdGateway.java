package io.github.jtsato.bookstore.core.documenttype.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateDocumentTypeByIdGateway {

    Optional<DocumentType> execute(final DocumentType documentType);
}

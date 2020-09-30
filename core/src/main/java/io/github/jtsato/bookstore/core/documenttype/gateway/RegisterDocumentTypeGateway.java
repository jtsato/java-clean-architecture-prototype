package io.github.jtsato.bookstore.core.documenttype.gateway;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterDocumentTypeGateway {

    DocumentType execute(final DocumentType documentType);
}

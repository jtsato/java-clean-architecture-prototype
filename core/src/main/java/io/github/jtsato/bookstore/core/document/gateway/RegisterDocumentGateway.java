package io.github.jtsato.bookstore.core.document.gateway;

import io.github.jtsato.bookstore.core.document.domain.Document;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterDocumentGateway {

    Document execute(final Document document);
}

package io.github.jtsato.bookstore.core.document.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.document.domain.Document;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateDocumentByIdGateway {

    Optional<Document> execute(final Document document);
}
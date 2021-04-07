package io.github.jtsato.bookstore.core.document.gateway;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchDocumentsByTypeIdGateway {

    Page<Document> execute(final Long typeId, final Integer pageNumber, final Integer size, final String orderBy);
}
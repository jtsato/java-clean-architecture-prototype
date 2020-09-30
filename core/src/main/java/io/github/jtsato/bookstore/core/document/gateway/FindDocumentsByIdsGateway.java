package io.github.jtsato.bookstore.core.document.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindDocumentsByIdsGateway {

    Page<Document> execute(final List<Long> ids);
}

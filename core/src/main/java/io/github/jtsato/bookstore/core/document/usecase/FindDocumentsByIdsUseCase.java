package io.github.jtsato.bookstore.core.document.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindDocumentsByIdsUseCase {

    Page<Document> execute(final List<Long> ids);
}

package io.github.jtsato.bookstore.core.documenttype.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindDocumentTypesByIdsUseCase {

    Page<DocumentType> execute(final List<Long> ids);
}

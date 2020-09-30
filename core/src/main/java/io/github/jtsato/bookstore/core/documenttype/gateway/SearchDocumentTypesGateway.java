package io.github.jtsato.bookstore.core.documenttype.gateway;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchDocumentTypesGateway {

    Page<DocumentType> execute(final SearchDocumentTypesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

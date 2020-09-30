package io.github.jtsato.bookstore.core.documenttype.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.SearchDocumentTypesGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.SearchDocumentTypesUseCase;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import lombok.RequiredArgsConstructor;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */

/**
 * @author Jorge Takeshi Sato
 */

@Named
@RequiredArgsConstructor
public class SearchDocumentTypesUseCaseImpl implements SearchDocumentTypesUseCase {

    private final SearchDocumentTypesGateway searchDocumentTypesGateway;

    @Override
    public Page<DocumentType> execute(final SearchDocumentTypesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchDocumentTypesGateway.execute(parameters, page, size, orderBy);
    }
}

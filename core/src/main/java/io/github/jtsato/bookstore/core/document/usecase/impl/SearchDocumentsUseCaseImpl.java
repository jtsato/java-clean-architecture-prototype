package io.github.jtsato.bookstore.core.document.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.SearchDocumentsGateway;
import io.github.jtsato.bookstore.core.document.usecase.SearchDocumentsUseCase;
import io.github.jtsato.bookstore.core.document.usecase.parameter.SearchDocumentsParameters;
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
public class SearchDocumentsUseCaseImpl implements SearchDocumentsUseCase {

    private final SearchDocumentsGateway searchDocumentsGateway;

    @Override
    public Page<Document> execute(final SearchDocumentsParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchDocumentsGateway.execute(parameters, page, size, orderBy);
    }
}

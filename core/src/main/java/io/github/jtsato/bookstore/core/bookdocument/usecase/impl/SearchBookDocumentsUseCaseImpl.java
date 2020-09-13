package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.SearchBookDocumentsGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.SearchBookDocumentsUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.SearchBookDocumentsParameters;
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
public class SearchBookDocumentsUseCaseImpl implements SearchBookDocumentsUseCase {

    private final SearchBookDocumentsGateway searchBookDocumentsGateway;

    @Override
    public Page<BookDocument> execute(final SearchBookDocumentsParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchBookDocumentsGateway.execute(parameters, page, size, orderBy);
    }
}

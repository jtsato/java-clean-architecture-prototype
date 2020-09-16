package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.FindBookDocumentsByIdsGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.FindBookDocumentsByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
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
public class FindBookDocumentsByIdsUseCaseImpl implements FindBookDocumentsByIdsUseCase {

    private final FindBookDocumentsByIdsGateway findBookDocumentsByIdsGateway;

    @Override
    public Page<BookDocument> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.book.document.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findBookDocumentsByIdsGateway.execute(ids);
    }
}

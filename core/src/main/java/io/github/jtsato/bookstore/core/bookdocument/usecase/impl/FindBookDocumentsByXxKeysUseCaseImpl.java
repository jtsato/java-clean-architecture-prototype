package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.FindBookDocumentsByXxKeysGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.FindBookDocumentsByXxKeysUseCase;
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
public class FindBookDocumentsByXxKeysUseCaseImpl implements FindBookDocumentsByXxKeysUseCase {

    private final FindBookDocumentsByXxKeysGateway findBookDocumentsByXxKeysGateway;

    @Override
    public Page<BookDocument> execute(final List<Long> xxKeys) {

        if (CollectionUtils.isEmpty(xxKeys)) {
            throw new InvalidParameterException("validation.book.document.xx.keys.null");
        }

        if (xxKeys.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.xx.keys.limit");
        }

        return findBookDocumentsByXxKeysGateway.execute(xxKeys);
    }
}

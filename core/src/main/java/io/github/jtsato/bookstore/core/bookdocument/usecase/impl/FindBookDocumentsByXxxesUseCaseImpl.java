package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.FindBookDocumentsByXxxesGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.FindBookDocumentsByXxxesUseCase;
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
public class FindBookDocumentsByXxxesUseCaseImpl implements FindBookDocumentsByXxxesUseCase {

    private final FindBookDocumentsByXxxesGateway findBookDocumentsByXxxesGateway;

    @Override
    public Page<BookDocument> execute(final List<Long> xxxes) {

        if (CollectionUtils.isEmpty(xxxes)) {
            throw new InvalidParameterException("validation.book.document.xxxes.null");
        }

        if (xxxes.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.xxxes.limit");
        }

        return findBookDocumentsByXxxesGateway.execute(xxxes);
    }
}

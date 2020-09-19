package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.RemoveBookByBbKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.RemoveBookByBbKeyUseCase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.SearchBookDocumentsByBookBbKeyGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.ParentConstraintException;
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
public class RemoveBookByBbKeyUseCaseImpl implements RemoveBookByBbKeyUseCase {

    private final RemoveBookByBbKeyGateway removeBookByBbKeyGateway;

    private final SearchBookDocumentsByBookBbKeyGateway searchBookDocumentsByBookBbKeyGateway;

    @Override
    public Book execute(final Long bbKey) {

        if (bbKey == null) {
            throw new InvalidParameterException("validation.book.bb.key.null");
        }

        avoidRemovingBookWithBookDocuments(bbKey);

        final Optional<Book> optional = removeBookByBbKeyGateway.execute(bbKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.bb.key.notfound", String.valueOf(bbKey)));
    }

    private void avoidRemovingBookWithBookDocuments(final Long bbKey) {

        final Page<BookDocument> pageOfBookDocuments = searchBookDocumentsByBookBbKeyGateway.execute(bbKey, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfBookDocuments.getContent())) {
            throw new ParentConstraintException("validation.book.with.book.documents.removal");
        }
    }
}

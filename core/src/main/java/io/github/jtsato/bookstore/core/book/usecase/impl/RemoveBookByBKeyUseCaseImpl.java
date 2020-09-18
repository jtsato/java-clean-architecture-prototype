package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.RemoveBookByBKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.RemoveBookByBKeyUseCase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.SearchBookDocumentsByBookBKeyGateway;
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
public class RemoveBookByBKeyUseCaseImpl implements RemoveBookByBKeyUseCase {

    private final RemoveBookByBKeyGateway removeBookByBKeyGateway;

    private final SearchBookDocumentsByBookBKeyGateway searchBookDocumentsByBookBKeyGateway;

    @Override
    public Book execute(final Long bKey) {

        if (bKey == null) {
            throw new InvalidParameterException("validation.book.b.key.null");
        }

        avoidRemovingBookWithBookDocuments(bKey);

        final Optional<Book> optional = removeBookByBKeyGateway.execute(bKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.b.key.notfound", String.valueOf(bKey)));
    }

    private void avoidRemovingBookWithBookDocuments(final Long bKey) {

        final Page<BookDocument> pageOfBookDocuments = searchBookDocumentsByBookBKeyGateway.execute(bKey, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfBookDocuments.getContent())) {
            throw new ParentConstraintException("validation.book.with.book.documents.removal");
        }
    }
}

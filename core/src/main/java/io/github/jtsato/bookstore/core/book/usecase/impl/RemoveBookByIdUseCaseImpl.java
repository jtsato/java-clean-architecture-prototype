package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.RemoveBookByIdGateway;
import io.github.jtsato.bookstore.core.book.usecase.RemoveBookByIdUseCase;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.SearchBookDocumentsByBookIdGateway;
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
public class RemoveBookByIdUseCaseImpl implements RemoveBookByIdUseCase {

    private final RemoveBookByIdGateway removeBookByIdGateway;

    private final SearchBookDocumentsByBookIdGateway searchBookDocumentsByBookIdGateway;

    @Override
    public Book execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.book.id.null");
        }

        avoidRemovingBookWithBookDocuments(id);

        final Optional<Book> optional = removeBookByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingBookWithBookDocuments(final Long id) {

        final Page<BookDocument> pageOfBookDocuments = searchBookDocumentsByBookIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfBookDocuments.getContent())) {
            throw new ParentConstraintException("validation.book.with.book.documents.removal");
        }
    }
}

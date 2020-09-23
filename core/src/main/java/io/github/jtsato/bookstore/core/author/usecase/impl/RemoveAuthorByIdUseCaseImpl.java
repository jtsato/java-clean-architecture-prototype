package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.RemoveAuthorByIdGateway;
import io.github.jtsato.bookstore.core.author.usecase.RemoveAuthorByIdUseCase;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.SearchBooksByAuthorIdGateway;
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
public class RemoveAuthorByIdUseCaseImpl implements RemoveAuthorByIdUseCase {

    private final RemoveAuthorByIdGateway removeAuthorByIdGateway;

    private final SearchBooksByAuthorIdGateway searchBooksByAuthorIdGateway;

    @Override
    public Author execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.author.id.null");
        }

        avoidRemovingAuthorWithBooks(id);

        final Optional<Author> optional = removeAuthorByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.author.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingAuthorWithBooks(final Long id) {

        final Page<Book> pageOfBooks = searchBooksByAuthorIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfBooks.getContent())) {
            throw new ParentConstraintException("validation.author.with.books.removal");
        }
    }
}
package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.RemoveAuthorByAKeyGateway;
import io.github.jtsato.bookstore.core.author.usecase.RemoveAuthorByAKeyUseCase;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.SearchBooksByAuthorAKeyGateway;
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
public class RemoveAuthorByAKeyUseCaseImpl implements RemoveAuthorByAKeyUseCase {

    private final RemoveAuthorByAKeyGateway removeAuthorByAKeyGateway;

    private final SearchBooksByAuthorAKeyGateway searchBooksByAuthorAKeyGateway;

    @Override
    public Author execute(final Long aKey) {

        if (aKey == null) {
            throw new InvalidParameterException("validation.author.a.key.null");
        }

        avoidRemovingAuthorWithBooks(aKey);

        final Optional<Author> optional = removeAuthorByAKeyGateway.execute(aKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.author.a.key.notfound", String.valueOf(aKey)));
    }

    private void avoidRemovingAuthorWithBooks(final Long aKey) {

        final Page<Book> pageOfBooks = searchBooksByAuthorAKeyGateway.execute(aKey, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfBooks.getContent())) {
            throw new ParentConstraintException("validation.author.with.books.removal");
        }
    }
}

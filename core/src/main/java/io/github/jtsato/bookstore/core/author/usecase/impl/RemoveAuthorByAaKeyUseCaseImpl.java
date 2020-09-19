package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.RemoveAuthorByAaKeyGateway;
import io.github.jtsato.bookstore.core.author.usecase.RemoveAuthorByAaKeyUseCase;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.SearchBooksByAuthorAaKeyGateway;
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
public class RemoveAuthorByAaKeyUseCaseImpl implements RemoveAuthorByAaKeyUseCase {

    private final RemoveAuthorByAaKeyGateway removeAuthorByAaKeyGateway;

    private final SearchBooksByAuthorAaKeyGateway searchBooksByAuthorAaKeyGateway;

    @Override
    public Author execute(final Long aaKey) {

        if (aaKey == null) {
            throw new InvalidParameterException("validation.author.aa.key.null");
        }

        avoidRemovingAuthorWithBooks(aaKey);

        final Optional<Author> optional = removeAuthorByAaKeyGateway.execute(aaKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.author.aa.key.notfound", String.valueOf(aaKey)));
    }

    private void avoidRemovingAuthorWithBooks(final Long aaKey) {

        final Page<Book> pageOfBooks = searchBooksByAuthorAaKeyGateway.execute(aaKey, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfBooks.getContent())) {
            throw new ParentConstraintException("validation.author.with.books.removal");
        }
    }
}

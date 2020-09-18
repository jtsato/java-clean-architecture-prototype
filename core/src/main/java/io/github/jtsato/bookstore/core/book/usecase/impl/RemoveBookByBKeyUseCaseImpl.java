package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.RemoveBookByBKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.RemoveBookByBKeyUseCase;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
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

    @Override
    public Book execute(final Long bKey) {

        if (bKey == null) {
            throw new InvalidParameterException("validation.book.b.key.null");
        }

        final Optional<Book> optional = removeBookByBKeyGateway.execute(bKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.b.key.notfound", String.valueOf(bKey)));
    }
}

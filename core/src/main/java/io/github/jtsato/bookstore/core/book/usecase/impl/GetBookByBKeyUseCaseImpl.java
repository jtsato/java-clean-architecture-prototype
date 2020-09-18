package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByBKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.GetBookByBKeyUseCase;
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
public class GetBookByBKeyUseCaseImpl implements GetBookByBKeyUseCase {

    private final GetBookByBKeyGateway getBookByBKeyGateway;

    @Override
    public Book execute(final Long bKey) {

        if (bKey == null) {
            throw new InvalidParameterException("validation.book.b.key.null");
        }

        final Optional<Book> optional = getBookByBKeyGateway.execute(bKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.b.key.notfound", String.valueOf(bKey)));
    }
}

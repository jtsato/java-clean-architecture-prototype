package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByBbKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.GetBookByBbKeyUseCase;
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
public class GetBookByBbKeyUseCaseImpl implements GetBookByBbKeyUseCase {

    private final GetBookByBbKeyGateway getBookByBbKeyGateway;

    @Override
    public Book execute(final Long bbKey) {

        if (bbKey == null) {
            throw new InvalidParameterException("validation.book.bb.key.null");
        }

        final Optional<Book> optional = getBookByBbKeyGateway.execute(bbKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.bb.key.notfound", String.valueOf(bbKey)));
    }
}

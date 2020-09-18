package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByAKeyGateway;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByTitleIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.book.gateway.UpdateBookByBKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.UpdateBookByBKeyUseCase;
import io.github.jtsato.bookstore.core.book.usecase.parameter.UpdateBookByBKeyParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.UniqueConstraintException;
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
public class UpdateBookByBKeyUseCaseImpl implements UpdateBookByBKeyUseCase {

    private final UpdateBookByBKeyGateway updateBookByBKeyGateway;

    private final GetAuthorByAKeyGateway getAuthorByAKeyGateway ;

    private final GetBookByTitleIgnoreCaseGateway getBookByTitleIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Book execute(final UpdateBookByBKeyParameters parameters) {

        final Author author = getAuthorAndValidate(parameters.getAuthorAKey());

        checkDuplicatedTitleViolation(parameters.getBKey(), parameters.getTitle());

        final Long bKey = parameters.getBKey();
        final String title = StringUtils.stripToEmpty(parameters.getTitle());
        final Boolean available = parameters.getAvailable();
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();
        final BigDecimal price = parameters.getPrice();

        final Book book = new Book(bKey ,
                                   author,
                                   title,
                                   available,
                                   null,
                                   lastModifiedDateTime,
                                   price);

        final Optional<Book> optional = updateBookByBKeyGateway.execute(book);
        return optional.orElseThrow(() -> new NotFoundException("validation.book.b.key.notfound", String.valueOf(parameters.getBKey())));
    }

    private Author getAuthorAndValidate(final Long authorAKey) {
        final Optional<Author> optional = getAuthorByAKeyGateway.execute(authorAKey);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.a.key.notfound", String.valueOf(authorAKey)));
    }

    private void checkDuplicatedTitleViolation(final Long bKey, final String title) {

        final Optional<Book> optional = getBookByTitleIgnoreCaseGateway.execute(title);

        if (optional.isEmpty()) {
            return;
        }

        final Book book = optional.get();
        if (!book.getBKey().equals(bKey)) {
            throw new UniqueConstraintException("validation.book.title.already.exists", book.getTitle());
        }
    }
}

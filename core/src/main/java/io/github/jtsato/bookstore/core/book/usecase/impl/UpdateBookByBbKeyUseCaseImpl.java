package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByAaKeyGateway;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByTitleIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.book.gateway.UpdateBookByBbKeyGateway;
import io.github.jtsato.bookstore.core.book.usecase.UpdateBookByBbKeyUseCase;
import io.github.jtsato.bookstore.core.book.usecase.parameter.UpdateBookByBbKeyParameters;
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
public class UpdateBookByBbKeyUseCaseImpl implements UpdateBookByBbKeyUseCase {

    private final UpdateBookByBbKeyGateway updateBookByBbKeyGateway;

    private final GetAuthorByAaKeyGateway getAuthorByAaKeyGateway ;

    private final GetBookByTitleIgnoreCaseGateway getBookByTitleIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Book execute(final UpdateBookByBbKeyParameters parameters) {

        final Author author = getAuthorAndValidate(parameters.getAuthorAaKey());

        checkDuplicatedTitleViolation(parameters.getBbKey(), parameters.getTitle());

        final Long bbKey = parameters.getBbKey();
        final String title = StringUtils.stripToEmpty(parameters.getTitle());
        final Boolean available = parameters.getAvailable();
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();
        final BigDecimal price = parameters.getPrice();

        final Book book = new Book(bbKey ,
                                   author,
                                   title,
                                   available,
                                   null,
                                   lastModifiedDateTime,
                                   price);

        final Optional<Book> optional = updateBookByBbKeyGateway.execute(book);
        return optional.orElseThrow(() -> new NotFoundException("validation.book.bb.key.notfound", String.valueOf(parameters.getBbKey())));
    }

    private Author getAuthorAndValidate(final Long authorAaKey) {
        final Optional<Author> optional = getAuthorByAaKeyGateway.execute(authorAaKey);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.aa.key.notfound", String.valueOf(authorAaKey)));
    }

    private void checkDuplicatedTitleViolation(final Long bbKey, final String title) {

        final Optional<Book> optional = getBookByTitleIgnoreCaseGateway.execute(title);

        if (optional.isEmpty()) {
            return;
        }

        final Book book = optional.get();
        if (!book.getBbKey().equals(bbKey)) {
            throw new UniqueConstraintException("validation.book.title.already.exists", book.getTitle());
        }
    }
}

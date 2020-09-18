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
import io.github.jtsato.bookstore.core.book.gateway.RegisterBookGateway;
import io.github.jtsato.bookstore.core.book.usecase.RegisterBookUseCase;
import io.github.jtsato.bookstore.core.book.usecase.parameter.RegisterBookParameters;
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
public class RegisterBookUseCaseImpl implements RegisterBookUseCase {

    private final RegisterBookGateway registerBookGateway;

    private final GetAuthorByAKeyGateway getAuthorByAKeyGateway ;

    private final GetBookByTitleIgnoreCaseGateway getBookByTitleIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Book execute(final RegisterBookParameters parameters) {

        final Author author = getAuthorAndValidate(parameters.getAuthorAKey());

        checkDuplicatedTitleViolation(parameters.getTitle());

        final String title = StringUtils.stripToEmpty(parameters.getTitle());
        final Boolean available = parameters.getAvailable();
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());
        final BigDecimal price = parameters.getPrice();

        final Book book = new Book(null,
                                   author,
                                   title,
                                   available,
                                   createdDateTime,
                                   lastModifiedDateTime,
                                   price);

        return registerBookGateway.execute(book);
    }

    private Author getAuthorAndValidate(final Long authorAKey) {
        final Optional<Author> optional = getAuthorByAKeyGateway.execute(authorAKey);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.a.key.notfound", String.valueOf(authorAKey)));
    }

    private void checkDuplicatedTitleViolation(final String title) {
        final Optional<Book> optional = getBookByTitleIgnoreCaseGateway.execute(title);
        optional.ifPresent(this::throwUniqueConstraintExceptionForTitle);
    }

    private void throwUniqueConstraintExceptionForTitle(final Book book) {
        throw new UniqueConstraintException("validation.book.title.already.exists", book.getTitle());
    }
}

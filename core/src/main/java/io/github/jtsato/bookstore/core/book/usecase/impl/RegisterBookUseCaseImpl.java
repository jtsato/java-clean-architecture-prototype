package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByIdGateway;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByExternalIdGateway;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByTitleIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByIsbnIgnoreCaseGateway;
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

    private final GetAuthorByIdGateway getAuthorByIdGateway ;

    private final GetBookByExternalIdGateway getBookByExternalIdGateway;

    private final GetBookByTitleIgnoreCaseGateway getBookByTitleIgnoreCaseGateway;

    private final GetBookByIsbnIgnoreCaseGateway getBookByIsbnIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Book execute(final RegisterBookParameters parameters) {

        final Author author = getAuthorAndValidate(parameters.getAuthorId());

        checkDuplicatedExternalIdViolation(parameters.getExternalId());

        checkDuplicatedTitleViolation(parameters.getTitle());

        checkDuplicatedIsbnViolation(parameters.getIsbn());

        final Long externalId = parameters.getExternalId();
        final String title = StringUtils.stripToEmpty(parameters.getTitle());
        final String isbn = StringUtils.stripToEmpty(parameters.getIsbn());
        final Boolean available = parameters.getAvailable();
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());
        final BigDecimal price = parameters.getPrice();

        final Book book = new Book(null,
                                   author,
                                   externalId,
                                   title,
                                   isbn,
                                   available,
                                   createdDateTime,
                                   lastModifiedDateTime,
                                   price);

        return registerBookGateway.execute(book);
    }

    private Author getAuthorAndValidate(final Long authorId) {
        final Optional<Author> optional = getAuthorByIdGateway.execute(authorId);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.id.notfound", String.valueOf(authorId)));
    }

    private void checkDuplicatedExternalIdViolation(final Long externalId) {
        final Optional<Book> optional = getBookByExternalIdGateway.execute(externalId);
        optional.ifPresent(this::throwUniqueConstraintExceptionForExternalId);
    }

    private void throwUniqueConstraintExceptionForExternalId(final Book book) {
        throw new UniqueConstraintException("validation.book.external.id.already.exists", book.getExternalId());
    }

    private void checkDuplicatedTitleViolation(final String title) {
        final Optional<Book> optional = getBookByTitleIgnoreCaseGateway.execute(title);
        optional.ifPresent(this::throwUniqueConstraintExceptionForTitle);
    }

    private void throwUniqueConstraintExceptionForTitle(final Book book) {
        throw new UniqueConstraintException("validation.book.title.already.exists", book.getTitle());
    }

    private void checkDuplicatedIsbnViolation(final String isbn) {
        final Optional<Book> optional = getBookByIsbnIgnoreCaseGateway.execute(isbn);
        optional.ifPresent(this::throwUniqueConstraintExceptionForIsbn);
    }

    private void throwUniqueConstraintExceptionForIsbn(final Book book) {
        throw new UniqueConstraintException("validation.book.isbn.already.exists", book.getIsbn());
    }
}

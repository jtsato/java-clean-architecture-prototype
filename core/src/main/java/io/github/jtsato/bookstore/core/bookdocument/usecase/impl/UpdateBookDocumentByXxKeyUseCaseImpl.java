package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByIdGateway;
import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.GetBookDocumentByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.bookdocument.gateway.UpdateBookDocumentByXxKeyGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.UpdateBookDocumentByXxKeyUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.UpdateBookDocumentByXxKeyParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDate;
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
public class UpdateBookDocumentByXxKeyUseCaseImpl implements UpdateBookDocumentByXxKeyUseCase {

    private final UpdateBookDocumentByXxKeyGateway updateBookDocumentByXxKeyGateway;

    private final GetBookDocumentByNameIgnoreCaseGateway getBookDocumentByNameIgnoreCaseGateway;

    private final GetBookByIdGateway getBookByIdGateway ;

    private final GetLocalDate getLocalDate;

    @Override
    public BookDocument execute(final UpdateBookDocumentByXxKeyParameters parameters) {

        final Book book = getBookAndValidate(parameters.getBookId());

        checkDuplicatedNameViolation(parameters.getXxKey(), parameters.getName());

        final Long xxKey = parameters.getXxKey();
        final Long size = parameters.getSize();
        final String contentType = StringUtils.stripToEmpty(parameters.getContentType());
        final String extension = StringUtils.stripToEmpty(parameters.getExtension());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String content = StringUtils.stripToEmpty(parameters.getContent());
        final LocalDate creationDate = getLocalDate.now();
        final LocalDate lastModifiedDate = getLocalDate.now();

        final BookDocument bookDocument = new BookDocument(xxKey ,
                                                           book,
                                                           size,
                                                           contentType,
                                                           extension,
                                                           name,
                                                           content,
                                                           creationDate,
                                                           lastModifiedDate);

        final Optional<BookDocument> optional = updateBookDocumentByXxKeyGateway.execute(bookDocument);
        return optional.orElseThrow(() -> new NotFoundException("validation.book.document.xx.key.notfound", String.valueOf(parameters.getXxKey())));
    }

    private Book getBookAndValidate(final Long bookId) {
        final Optional<Book> optional = getBookByIdGateway.execute(bookId);
        return optional.orElseThrow(() -> new NotFoundException("validation.book.id.notfound", String.valueOf(bookId)));
    }

    private void checkDuplicatedNameViolation(final Long xxKey, final String name) {

        final Optional<BookDocument> optional = getBookDocumentByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final BookDocument bookDocument = optional.get();
        if (!bookDocument.getXxKey().equals(xxKey)) {
            throw new UniqueConstraintException("validation.book.document.name.already.exists", bookDocument.getName());
        }
    }
}

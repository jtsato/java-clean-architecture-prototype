package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByIdGateway;
import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.GetBookDocumentByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RegisterBookDocumentGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.RegisterBookDocumentUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.RegisterBookDocumentParameters;
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
public class RegisterBookDocumentUseCaseImpl implements RegisterBookDocumentUseCase {

    private final RegisterBookDocumentGateway registerBookDocumentGateway;

    private final GetBookByIdGateway getBookByIdGateway ;

    private final GetBookDocumentByNameIgnoreCaseGateway getBookDocumentByNameIgnoreCaseGateway;

    @Override
    public BookDocument execute(final RegisterBookDocumentParameters parameters) {

        final Book book = getBookAndValidate(parameters.getBookId());

        checkDuplicatedNameViolation(parameters.getName());

        final Long size = parameters.getSize();
        final String contentType = StringUtils.stripToEmpty(parameters.getContentType());
        final String extension = StringUtils.stripToEmpty(parameters.getExtension());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String content = StringUtils.stripToEmpty(parameters.getContent());
        final LocalDate creationDate = LocalDate.parse(parameters.getCreationDate());
        final LocalDate lastModifiedDate = LocalDate.parse(parameters.getLastModifiedDate());

        final BookDocument bookDocument = new BookDocument(null,
                                                           book,
                                                           size,
                                                           contentType,
                                                           extension,
                                                           name,
                                                           content,
                                                           creationDate,
                                                           lastModifiedDate);

        return registerBookDocumentGateway.execute(bookDocument);
    }

    private Book getBookAndValidate(final Long bookId) {
        final Optional<Book> optional = getBookByIdGateway.execute(bookId);
        return optional.orElseThrow(() -> new NotFoundException("validation.book.id.notfound", String.valueOf(bookId)));
    }

    private void checkDuplicatedNameViolation(final String name) {
        final Optional<BookDocument> optional = getBookDocumentByNameIgnoreCaseGateway.execute(name);
        optional.ifPresent(this::throwUniqueConstraintExceptionForName);
    }

    private void throwUniqueConstraintExceptionForName(final BookDocument bookDocument) {
        throw new UniqueConstraintException("validation.book.document.name.already.exists", bookDocument.getName());
    }
}

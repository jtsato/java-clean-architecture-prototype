package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.GetBookDocumentByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RegisterBookDocumentGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.RegisterBookDocumentUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.RegisterBookDocumentParameters;
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

    private final GetBookDocumentByNameIgnoreCaseGateway getBookDocumentByNameIgnoreCaseGateway;

    @Override
    public BookDocument execute(final RegisterBookDocumentParameters parameters) {

        checkDuplicatedNameViolation(parameters.getName());

        final Long bookId = parameters.getBookId();
        final Long size = parameters.getSize();
        final String contentType = StringUtils.stripToEmpty(parameters.getContentType());
        final String extension = StringUtils.stripToEmpty(parameters.getExtension());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String content = StringUtils.stripToEmpty(parameters.getContent());
        final LocalDateTime creationDate = LocalDateTime.parse(parameters.getCreationDate());
        final LocalDateTime lastModifiedDate = LocalDateTime.parse(parameters.getLastModifiedDate());

        final BookDocument bookDocument = new BookDocument(null,
                                                           bookId,
                                                           size,
                                                           contentType,
                                                           extension,
                                                           name,
                                                           content,
                                                           creationDate,
                                                           lastModifiedDate);

        return registerBookDocumentGateway.execute(bookDocument);
    }

    private void checkDuplicatedNameViolation(final String name) {
        final Optional<BookDocument> optional = getBookDocumentByNameIgnoreCaseGateway.execute(name);
        optional.ifPresent(this::throwUniqueConstraintExceptionForName);
    }

    private void throwUniqueConstraintExceptionForName(final BookDocument bookDocument) {
        throw new UniqueConstraintException("validation.book.document.name.already.exists", bookDocument.getName());
    }
}

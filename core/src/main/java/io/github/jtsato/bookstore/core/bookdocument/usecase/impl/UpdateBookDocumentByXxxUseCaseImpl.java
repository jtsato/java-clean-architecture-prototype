package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.GetBookDocumentByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.bookdocument.gateway.UpdateBookDocumentByXxxGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.UpdateBookDocumentByXxxUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.UpdateBookDocumentByXxxParameters;
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
public class UpdateBookDocumentByXxxUseCaseImpl implements UpdateBookDocumentByXxxUseCase {

    private final UpdateBookDocumentByXxxGateway updateBookDocumentByXxxGateway;

    private final GetBookDocumentByNameIgnoreCaseGateway getBookDocumentByNameIgnoreCaseGateway;

    @Override
    public BookDocument execute(final UpdateBookDocumentByXxxParameters parameters) {

        checkDuplicatedNameViolation(parameters.getXxx(), parameters.getName());

        final Long Xxx = parameters.getXxx();
        final Long bookId = parameters.getBookId();
        final Long size = parameters.getSize();
        final String contentType = StringUtils.stripToEmpty(parameters.getContentType());
        final String extension = StringUtils.stripToEmpty(parameters.getExtension());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String content = StringUtils.stripToEmpty(parameters.getContent());
        final LocalDateTime creationDate = LocalDateTime.parse(parameters.getCreationDate());
        final LocalDateTime lastModifiedDate = LocalDateTime.parse(parameters.getLastModifiedDate());

        final BookDocument bookDocument = new BookDocument(Xxx ,
                                                           bookId,
                                                           size,
                                                           contentType,
                                                           extension,
                                                           name,
                                                           content,
                                                           creationDate,
                                                           lastModifiedDate);

        final Optional<BookDocument> optional = updateBookDocumentByXxxGateway.execute(bookDocument);
        return optional.orElseThrow(() -> new NotFoundException("validation.book.document.xxx.notfound", String.valueOf(parameters.getXxx())));
    }

    private void checkDuplicatedNameViolation(final Long xxx, final String name) {

        final Optional<BookDocument> optional = getBookDocumentByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final BookDocument bookDocument = optional.get();
        if (!bookDocument.getXxx().equals(xxx)) {
            throw new UniqueConstraintException("validation.book.document.name.already.exists", bookDocument.getName());
        }
    }
}

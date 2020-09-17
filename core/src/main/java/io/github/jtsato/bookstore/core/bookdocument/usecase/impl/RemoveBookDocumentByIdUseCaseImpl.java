package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RemoveBookDocumentByIdGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.RemoveBookDocumentByIdUseCase;
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
public class RemoveBookDocumentByIdUseCaseImpl implements RemoveBookDocumentByIdUseCase {

    private final RemoveBookDocumentByIdGateway removeBookDocumentByIdGateway;

    @Override
    public BookDocument execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.book.document.id.null");
        }

        final Optional<BookDocument> optional = removeBookDocumentByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.document.id.notfound", String.valueOf(id)));
    }
}

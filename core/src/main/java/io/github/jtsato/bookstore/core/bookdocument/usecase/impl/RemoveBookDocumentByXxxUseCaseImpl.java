package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RemoveBookDocumentByXxxGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.RemoveBookDocumentByXxxUseCase;
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
public class RemoveBookDocumentByXxxUseCaseImpl implements RemoveBookDocumentByXxxUseCase {

    private final RemoveBookDocumentByXxxGateway removeBookDocumentByXxxGateway;

    @Override
    public BookDocument execute(final Long xxx) {

        if (xxx == null) {
            throw new InvalidParameterException("validation.book.document.xxx.null");
        }

        final Optional<BookDocument> optional = removeBookDocumentByXxxGateway.execute(xxx);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.document.xxx.notfound", String.valueOf(xxx)));
    }
}

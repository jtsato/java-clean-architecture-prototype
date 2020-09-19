package io.github.jtsato.bookstore.core.bookdocument.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.GetBookDocumentByXxKeyGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.GetBookDocumentByXxKeyUseCase;
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
public class GetBookDocumentByXxKeyUseCaseImpl implements GetBookDocumentByXxKeyUseCase {

    private final GetBookDocumentByXxKeyGateway getBookDocumentByXxKeyGateway;

    @Override
    public BookDocument execute(final Long xxKey) {

        if (xxKey == null) {
            throw new InvalidParameterException("validation.book.document.xx.key.null");
        }

        final Optional<BookDocument> optional = getBookDocumentByXxKeyGateway.execute(xxKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.book.document.xx.key.notfound", String.valueOf(xxKey)));
    }
}

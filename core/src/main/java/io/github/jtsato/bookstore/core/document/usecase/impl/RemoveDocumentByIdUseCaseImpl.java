package io.github.jtsato.bookstore.core.document.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.RemoveDocumentByIdGateway;
import io.github.jtsato.bookstore.core.document.usecase.RemoveDocumentByIdUseCase;
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
public class RemoveDocumentByIdUseCaseImpl implements RemoveDocumentByIdUseCase {

    private final RemoveDocumentByIdGateway removeDocumentByIdGateway;

    @Override
    public Document execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.document.id.null");
        }

        final Optional<Document> optional = removeDocumentByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.document.id.notfound", String.valueOf(id)));
    }
}

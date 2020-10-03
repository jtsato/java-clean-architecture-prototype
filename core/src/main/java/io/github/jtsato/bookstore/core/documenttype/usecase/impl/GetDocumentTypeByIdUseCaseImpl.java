package io.github.jtsato.bookstore.core.documenttype.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.GetDocumentTypeByIdGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.GetDocumentTypeByIdUseCase;
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
public class GetDocumentTypeByIdUseCaseImpl implements GetDocumentTypeByIdUseCase {

    private final GetDocumentTypeByIdGateway getDocumentTypeByIdGateway;

    @Override
    public DocumentType execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.document.type.id.null");
        }

        final Optional<DocumentType> optional = getDocumentTypeByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.document.type.id.notfound", String.valueOf(id)));
    }
}

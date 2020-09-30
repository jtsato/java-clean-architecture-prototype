package io.github.jtsato.bookstore.core.documenttype.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.UpdateDocumentTypeByIdGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.UpdateDocumentTypeByIdUseCase;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.UpdateDocumentTypeByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
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
public class UpdateDocumentTypeByIdUseCaseImpl implements UpdateDocumentTypeByIdUseCase {

    private final UpdateDocumentTypeByIdGateway updateDocumentTypeByIdGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public DocumentType execute(final UpdateDocumentTypeByIdParameters parameters) {

        final Long id = parameters.getId();
        final String country = StringUtils.stripToEmpty(parameters.getCountry());
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final DocumentType documentType = new DocumentType(id ,
                                                           country,
                                                           description,
                                                           null,
                                                           lastModifiedDateTime);

        final Optional<DocumentType> optional = updateDocumentTypeByIdGateway.execute(documentType);
        return optional.orElseThrow(() -> new NotFoundException("validation.document.type.id.notfound", String.valueOf(parameters.getId())));
    }
}

package io.github.jtsato.bookstore.core.documenttype.usecase.impl;

import java.time.LocalDateTime;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.RegisterDocumentTypeGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.RegisterDocumentTypeUseCase;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.RegisterDocumentTypeParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
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
public class RegisterDocumentTypeUseCaseImpl implements RegisterDocumentTypeUseCase {

    private final RegisterDocumentTypeGateway registerDocumentTypeGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public DocumentType execute(final RegisterDocumentTypeParameters parameters) {

        final String country = StringUtils.stripToEmpty(parameters.getCountry());
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final DocumentType documentType = new DocumentType(null, country, description, createdDateTime, lastModifiedDateTime);

        return registerDocumentTypeGateway.execute(documentType);
    }
}

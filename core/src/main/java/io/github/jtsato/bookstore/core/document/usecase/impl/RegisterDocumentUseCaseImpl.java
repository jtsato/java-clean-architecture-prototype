package io.github.jtsato.bookstore.core.document.usecase.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByIdGateway;
import io.github.jtsato.bookstore.core.documenttype.gateway.GetDocumentTypeByIdGateway;
import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.GetDocumentByNumberIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.document.gateway.RegisterDocumentGateway;
import io.github.jtsato.bookstore.core.document.usecase.RegisterDocumentUseCase;
import io.github.jtsato.bookstore.core.document.usecase.parameter.RegisterDocumentParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
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
public class RegisterDocumentUseCaseImpl implements RegisterDocumentUseCase {

    private final RegisterDocumentGateway registerDocumentGateway;

    private final GetLeadByIdGateway getLeadByIdGateway;

    private final GetDocumentTypeByIdGateway getDocumentTypeByIdGateway;

    private final GetDocumentByNumberIgnoreCaseGateway getDocumentByNumberIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Document execute(final RegisterDocumentParameters parameters) {

        final Lead lead = getLeadAndValidate(parameters.getLeadId());

        final DocumentType type = getDocumentTypeAndValidate(parameters.getTypeId());

        checkDuplicatedNumberViolation(parameters.getNumber());

        final Long frontPhoto = parameters.getFrontPhoto();
        final Long backPhoto = parameters.getBackPhoto();
        final String number = StringUtils.stripToEmpty(parameters.getNumber());
        final String issuer = StringUtils.stripToEmpty(parameters.getIssuer());
        final String state = StringUtils.stripToEmpty(parameters.getState());
        final LocalDate issueDate = LocalDate.parse(parameters.getIssueDate());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Document document = new Document(null,
                                               lead,
                                               type,
                                               frontPhoto,
                                               backPhoto,
                                               number,
                                               issuer,
                                               state,
                                               issueDate,
                                               createdDateTime,
                                               lastModifiedDateTime);

        return registerDocumentGateway.execute(document);
    }

    private Lead getLeadAndValidate(final Long leadId) {
        final Optional<Lead> optional = getLeadByIdGateway.execute(leadId);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(leadId)));
    }

    private DocumentType getDocumentTypeAndValidate(final Long typeId) {
        final Optional<DocumentType> optional = getDocumentTypeByIdGateway.execute(typeId);
        return optional.orElseThrow(() -> new NotFoundException("validation.document.type.id.notfound", String.valueOf(typeId)));
    }

    private void checkDuplicatedNumberViolation(final String number) {
        final Optional<Document> optional = getDocumentByNumberIgnoreCaseGateway.execute(number);
        optional.ifPresent(this::throwUniqueConstraintExceptionForNumber);
    }

    private void throwUniqueConstraintExceptionForNumber(final Document document) {
        throw new UniqueConstraintException("validation.document.number.already.exists", document.getNumber());
    }
}

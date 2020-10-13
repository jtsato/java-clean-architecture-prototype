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
import io.github.jtsato.bookstore.core.document.gateway.UpdateDocumentByIdGateway;
import io.github.jtsato.bookstore.core.document.usecase.UpdateDocumentByIdUseCase;
import io.github.jtsato.bookstore.core.document.usecase.parameter.UpdateDocumentByIdParameters;
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
public class UpdateDocumentByIdUseCaseImpl implements UpdateDocumentByIdUseCase {

    private final UpdateDocumentByIdGateway updateDocumentByIdGateway;

    private final GetDocumentByNumberIgnoreCaseGateway getDocumentByNumberIgnoreCaseGateway;

    private final GetLeadByIdGateway getLeadByIdGateway;

    private final GetDocumentTypeByIdGateway getDocumentTypeByIdGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Document execute(final UpdateDocumentByIdParameters parameters) {
        final Lead lead = getLeadAndValidate(parameters.getLeadId());
        final DocumentType type = getDocumentTypeAndValidate(parameters.getTypeId());

        checkDuplicatedNumberViolation(parameters.getId(), parameters.getNumber());

        final Long id = parameters.getId();
        final Long frontPhoto = parameters.getFrontPhoto();
        final Long backPhoto = parameters.getBackPhoto();
        final String number = StringUtils.stripToEmpty(parameters.getNumber());
        final String issuer = StringUtils.stripToEmpty(parameters.getIssuer());
        final String state = StringUtils.stripToEmpty(parameters.getState());
        final LocalDate issueDate = LocalDate.parse(parameters.getIssueDate());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Document document = new Document(id ,
                                               lead,
                                               type,
                                               frontPhoto,
                                               backPhoto,
                                               number,
                                               issuer,
                                               state,
                                               issueDate,
                                               null,
                                               lastModifiedDateTime);

        final Optional<Document> optional = updateDocumentByIdGateway.execute(document);
        return optional.orElseThrow(() -> new NotFoundException("validation.document.id.notfound", String.valueOf(parameters.getId())));
    }

    private Lead getLeadAndValidate(final Long leadId) {
        final Optional<Lead> optional = getLeadByIdGateway.execute(leadId);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(leadId)));
    }

    private DocumentType getDocumentTypeAndValidate(final Long typeId) {
        final Optional<DocumentType> optional = getDocumentTypeByIdGateway.execute(typeId);
        return optional.orElseThrow(() -> new NotFoundException("validation.document.type.id.notfound", String.valueOf(typeId)));
    }

    private void checkDuplicatedNumberViolation(final Long id, final String number) {

        final Optional<Document> optional = getDocumentByNumberIgnoreCaseGateway.execute(number);

        if (optional.isEmpty()) {
            return;
        }

        final Document document = optional.get();
        if (!document.getId().equals(id)) {
            throw new UniqueConstraintException("validation.document.number.already.exists", document.getNumber());
        }
    }
}

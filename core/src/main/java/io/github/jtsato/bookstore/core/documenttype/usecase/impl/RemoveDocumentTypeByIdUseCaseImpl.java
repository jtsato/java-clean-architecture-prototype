package io.github.jtsato.bookstore.core.documenttype.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.SearchDocumentsByTypeIdGateway;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.RemoveDocumentTypeByIdGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.RemoveDocumentTypeByIdUseCase;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.ParentConstraintException;
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
public class RemoveDocumentTypeByIdUseCaseImpl implements RemoveDocumentTypeByIdUseCase {

    private final RemoveDocumentTypeByIdGateway removeDocumentTypeByIdGateway;

    private final SearchDocumentsByTypeIdGateway searchDocumentsByTypeIdGateway;

    @Override
    public DocumentType execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.document.type.id.null");
        }

        avoidRemovingDocumentTypeWithDocuments(id);

        final Optional<DocumentType> optional = removeDocumentTypeByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.document.type.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingDocumentTypeWithDocuments(final Long id) {

        final Page<Document> pageOfDocuments = searchDocumentsByTypeIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfDocuments.getContent())) {
            throw new ParentConstraintException("validation.document.type.with.documents.removal");
        }
    }
}

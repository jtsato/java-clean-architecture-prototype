package io.github.jtsato.bookstore.core.documenttype.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.FindDocumentTypesByIdsGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.FindDocumentTypesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
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
public class FindDocumentTypesByIdsUseCaseImpl implements FindDocumentTypesByIdsUseCase {

    private final FindDocumentTypesByIdsGateway findDocumentTypesByIdsGateway;

    @Override
    public Page<DocumentType> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.document.type.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findDocumentTypesByIdsGateway.execute(ids);
    }
}

package io.github.jtsato.bookstore.core.document.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.FindDocumentsByIdsGateway;
import io.github.jtsato.bookstore.core.document.usecase.FindDocumentsByIdsUseCase;
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
public class FindDocumentsByIdsUseCaseImpl implements FindDocumentsByIdsUseCase {

    private final FindDocumentsByIdsGateway findDocumentsByIdsGateway;

    @Override
    public Page<Document> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.document.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findDocumentsByIdsGateway.execute(ids);
    }
}

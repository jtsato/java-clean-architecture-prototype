package io.github.jtsato.bookstore.core.file.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.FindFilesByIdsGateway;
import io.github.jtsato.bookstore.core.file.usecase.FindFilesByIdsUseCase;
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
public class FindFilesByIdsUseCaseImpl implements FindFilesByIdsUseCase {

    private final FindFilesByIdsGateway findFilesByIdsGateway;

    @Override
    public Page<File> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.file.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findFilesByIdsGateway.execute(ids);
    }
}

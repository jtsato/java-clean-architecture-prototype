package io.github.jtsato.bookstore.core.file.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.SearchFilesGateway;
import io.github.jtsato.bookstore.core.file.usecase.SearchFilesUseCase;
import io.github.jtsato.bookstore.core.file.usecase.parameter.SearchFilesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
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
public class SearchFilesUseCaseImpl implements SearchFilesUseCase {

    private final SearchFilesGateway searchFilesGateway;

    @Override
    public Page<File> execute(final SearchFilesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchFilesGateway.execute(parameters, page, size, orderBy);
    }
}

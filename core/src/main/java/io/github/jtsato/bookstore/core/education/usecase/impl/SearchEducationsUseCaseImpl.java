package io.github.jtsato.bookstore.core.education.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.gateway.SearchEducationsGateway;
import io.github.jtsato.bookstore.core.education.usecase.SearchEducationsUseCase;
import io.github.jtsato.bookstore.core.education.usecase.parameter.SearchEducationsParameters;
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
public class SearchEducationsUseCaseImpl implements SearchEducationsUseCase {

    private final SearchEducationsGateway searchEducationsGateway;

    @Override
    public Page<Education> execute(final SearchEducationsParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchEducationsGateway.execute(parameters, page, size, orderBy);
    }
}

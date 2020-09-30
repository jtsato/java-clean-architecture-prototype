package io.github.jtsato.bookstore.core.maritalstatus.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.gateway.SearchMaritalStatusesGateway;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.SearchMaritalStatusesUseCase;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter.SearchMaritalStatusesParameters;
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
public class SearchMaritalStatusesUseCaseImpl implements SearchMaritalStatusesUseCase {

    private final SearchMaritalStatusesGateway searchMaritalStatusesGateway;

    @Override
    public Page<MaritalStatus> execute(final SearchMaritalStatusesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchMaritalStatusesGateway.execute(parameters, page, size, orderBy);
    }
}

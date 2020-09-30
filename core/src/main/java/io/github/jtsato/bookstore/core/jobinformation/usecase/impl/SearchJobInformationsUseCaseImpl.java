package io.github.jtsato.bookstore.core.jobinformation.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.SearchJobInformationsGateway;
import io.github.jtsato.bookstore.core.jobinformation.usecase.SearchJobInformationsUseCase;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.SearchJobInformationsParameters;
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
public class SearchJobInformationsUseCaseImpl implements SearchJobInformationsUseCase {

    private final SearchJobInformationsGateway searchJobInformationsGateway;

    @Override
    public Page<JobInformation> execute(final SearchJobInformationsParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchJobInformationsGateway.execute(parameters, page, size, orderBy);
    }
}

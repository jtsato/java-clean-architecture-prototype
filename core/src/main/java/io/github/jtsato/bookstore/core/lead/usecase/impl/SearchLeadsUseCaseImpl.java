package io.github.jtsato.bookstore.core.lead.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.SearchLeadsGateway;
import io.github.jtsato.bookstore.core.lead.usecase.SearchLeadsUseCase;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
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
public class SearchLeadsUseCaseImpl implements SearchLeadsUseCase {

    private final SearchLeadsGateway searchLeadsGateway;

    @Override
    public Page<Lead> execute(final SearchLeadsParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchLeadsGateway.execute(parameters, page, size, orderBy);
    }
}

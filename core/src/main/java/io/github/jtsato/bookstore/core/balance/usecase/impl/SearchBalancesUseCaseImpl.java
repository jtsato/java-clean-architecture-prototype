package io.github.jtsato.bookstore.core.balance.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.SearchBalancesGateway;
import io.github.jtsato.bookstore.core.balance.usecase.SearchBalancesUseCase;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.SearchBalancesParameters;
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
public class SearchBalancesUseCaseImpl implements SearchBalancesUseCase {

    private final SearchBalancesGateway searchBalancesGateway;

    @Override
    public Page<Balance> execute(final SearchBalancesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchBalancesGateway.execute(parameters, page, size, orderBy);
    }
}

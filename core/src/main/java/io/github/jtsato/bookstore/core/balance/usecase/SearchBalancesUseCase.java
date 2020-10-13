package io.github.jtsato.bookstore.core.balance.usecase;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.SearchBalancesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchBalancesUseCase {

    Page<Balance> execute(final SearchBalancesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

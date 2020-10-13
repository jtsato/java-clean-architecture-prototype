package io.github.jtsato.bookstore.core.balance.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindBalancesByIdsUseCase {

    Page<Balance> execute(final List<Long> ids);
}

package io.github.jtsato.bookstore.core.balance.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindBalancesByIdsGateway {

    Page<Balance> execute(final List<Long> ids);
}

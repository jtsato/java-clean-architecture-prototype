package io.github.jtsato.bookstore.core.balance.gateway;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterBalanceGateway {

    Balance execute(final Balance balance);
}

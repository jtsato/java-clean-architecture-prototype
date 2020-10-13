package io.github.jtsato.bookstore.core.balance.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetBalanceByIdGateway {

    Optional<Balance> execute(final Long Id);
}
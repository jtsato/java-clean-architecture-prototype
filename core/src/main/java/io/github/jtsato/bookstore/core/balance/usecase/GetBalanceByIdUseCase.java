package io.github.jtsato.bookstore.core.balance.usecase;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetBalanceByIdUseCase {

    Balance execute(final Long Id);
}

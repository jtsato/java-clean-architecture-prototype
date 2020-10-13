package io.github.jtsato.bookstore.core.balance.usecase;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveBalanceByIdUseCase {

    Balance execute(final Long Id);
}

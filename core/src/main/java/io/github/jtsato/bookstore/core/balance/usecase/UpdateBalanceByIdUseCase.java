package io.github.jtsato.bookstore.core.balance.usecase;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.UpdateBalanceByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateBalanceByIdUseCase {

    Balance execute(final UpdateBalanceByIdParameters parameters);
}

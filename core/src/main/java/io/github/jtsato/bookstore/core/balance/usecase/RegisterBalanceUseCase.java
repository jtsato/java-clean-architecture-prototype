package io.github.jtsato.bookstore.core.balance.usecase;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.RegisterBalanceParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterBalanceUseCase {

    Balance execute(final RegisterBalanceParameters parameters);
}

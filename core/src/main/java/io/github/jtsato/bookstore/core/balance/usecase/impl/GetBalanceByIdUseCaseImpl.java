package io.github.jtsato.bookstore.core.balance.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.GetBalanceByIdGateway;
import io.github.jtsato.bookstore.core.balance.usecase.GetBalanceByIdUseCase;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
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
public class GetBalanceByIdUseCaseImpl implements GetBalanceByIdUseCase {

    private final GetBalanceByIdGateway getBalanceByIdGateway;

    @Override
    public Balance execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.balance.id.null");
        }

        final Optional<Balance> optional = getBalanceByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.balance.id.notfound", String.valueOf(id)));
    }
}

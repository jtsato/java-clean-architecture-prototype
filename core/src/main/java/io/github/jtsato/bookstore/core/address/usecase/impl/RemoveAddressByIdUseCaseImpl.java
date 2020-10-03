package io.github.jtsato.bookstore.core.address.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.RemoveAddressByIdGateway;
import io.github.jtsato.bookstore.core.address.usecase.RemoveAddressByIdUseCase;
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
public class RemoveAddressByIdUseCaseImpl implements RemoveAddressByIdUseCase {

    private final RemoveAddressByIdGateway removeAddressByIdGateway;

    @Override
    public Address execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.address.id.null");
        }

        final Optional<Address> optional = removeAddressByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.address.id.notfound", String.valueOf(id)));
    }
}

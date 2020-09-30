package io.github.jtsato.bookstore.core.maritalstatus.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.gateway.GetMaritalStatusByIdGateway;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.GetMaritalStatusByIdUseCase;
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
public class GetMaritalStatusByIdUseCaseImpl implements GetMaritalStatusByIdUseCase {

    private final GetMaritalStatusByIdGateway getMaritalStatusByIdGateway;

    @Override
    public MaritalStatus execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.marital.status.id.null");
        }
        final Optional<MaritalStatus> optional = getMaritalStatusByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.marital.status.id.notfound", String.valueOf(id)));
    }
}

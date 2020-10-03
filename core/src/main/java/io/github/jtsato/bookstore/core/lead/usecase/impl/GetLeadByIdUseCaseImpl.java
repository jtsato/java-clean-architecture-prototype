package io.github.jtsato.bookstore.core.lead.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByIdGateway;
import io.github.jtsato.bookstore.core.lead.usecase.GetLeadByIdUseCase;
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
public class GetLeadByIdUseCaseImpl implements GetLeadByIdUseCase {

    private final GetLeadByIdGateway getLeadByIdGateway;

    @Override
    public Lead execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.lead.id.null");
        }

        final Optional<Lead> optional = getLeadByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(id)));
    }
}

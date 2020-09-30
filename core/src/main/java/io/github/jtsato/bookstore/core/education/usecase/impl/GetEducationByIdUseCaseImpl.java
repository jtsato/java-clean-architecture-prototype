package io.github.jtsato.bookstore.core.education.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.gateway.GetEducationByIdGateway;
import io.github.jtsato.bookstore.core.education.usecase.GetEducationByIdUseCase;
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
public class GetEducationByIdUseCaseImpl implements GetEducationByIdUseCase {

    private final GetEducationByIdGateway getEducationByIdGateway;

    @Override
    public Education execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.education.id.null");
        }
        final Optional<Education> optional = getEducationByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.education.id.notfound", String.valueOf(id)));
    }
}

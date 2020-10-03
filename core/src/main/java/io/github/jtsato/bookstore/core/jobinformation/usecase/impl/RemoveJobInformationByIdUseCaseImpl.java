package io.github.jtsato.bookstore.core.jobinformation.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.RemoveJobInformationByIdGateway;
import io.github.jtsato.bookstore.core.jobinformation.usecase.RemoveJobInformationByIdUseCase;
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
public class RemoveJobInformationByIdUseCaseImpl implements RemoveJobInformationByIdUseCase {

    private final RemoveJobInformationByIdGateway removeJobInformationByIdGateway;

    @Override
    public JobInformation execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.job.information.id.null");
        }

        final Optional<JobInformation> optional = removeJobInformationByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.job.information.id.notfound", String.valueOf(id)));
    }
}

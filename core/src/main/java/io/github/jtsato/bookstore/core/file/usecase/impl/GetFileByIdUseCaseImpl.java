package io.github.jtsato.bookstore.core.file.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.GetFileByIdGateway;
import io.github.jtsato.bookstore.core.file.usecase.GetFileByIdUseCase;
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
public class GetFileByIdUseCaseImpl implements GetFileByIdUseCase {

    private final GetFileByIdGateway getFileByIdGateway;

    @Override
    public File execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.file.id.null");
        }
        final Optional<File> optional = getFileByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.file.id.notfound", String.valueOf(id)));
    }
}

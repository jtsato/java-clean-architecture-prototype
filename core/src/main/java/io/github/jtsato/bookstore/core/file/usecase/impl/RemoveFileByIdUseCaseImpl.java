package io.github.jtsato.bookstore.core.file.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.RemoveFileByIdGateway;
import io.github.jtsato.bookstore.core.file.usecase.RemoveFileByIdUseCase;
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
public class RemoveFileByIdUseCaseImpl implements RemoveFileByIdUseCase {

    private final RemoveFileByIdGateway removeFileByIdGateway;

    @Override
    public File execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.file.id.null");
        }

        final Optional<File> optional = removeFileByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.file.id.notfound", String.valueOf(id)));
    }
}

package io.github.jtsato.bookstore.core.file.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.GetFileByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.file.gateway.RegisterFileGateway;
import io.github.jtsato.bookstore.core.file.usecase.RegisterFileUseCase;
import io.github.jtsato.bookstore.core.file.usecase.parameter.RegisterFileParameters;
import io.github.jtsato.bookstore.core.exception.UniqueConstraintException;
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
public class RegisterFileUseCaseImpl implements RegisterFileUseCase {

    private final RegisterFileGateway registerFileGateway;

    private final GetFileByNameIgnoreCaseGateway getFileByNameIgnoreCaseGateway;

    @Override
    public File execute(final RegisterFileParameters parameters) {

        checkDuplicatedNameViolation(parameters.getName());

        final Long size = parameters.getSize();
        final String contentType = StringUtils.stripToEmpty(parameters.getContentType());
        final String extension = StringUtils.stripToEmpty(parameters.getExtension());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String content = StringUtils.stripToEmpty(parameters.getContent());
        final String url = StringUtils.stripToEmpty(parameters.getUrl());
        final LocalDate creationDate = LocalDate.parse(parameters.getCreationDate());
        final LocalDate lastModifiedDate = LocalDate.parse(parameters.getLastModifiedDate());

        final File file = new File(null,
                                   size,
                                   contentType,
                                   extension,
                                   name,
                                   content,
                                   url,
                                   creationDate,
                                   lastModifiedDate);

        return registerFileGateway.execute(file);
    }

    private void checkDuplicatedNameViolation(final String name) {
        final Optional<File> optional = getFileByNameIgnoreCaseGateway.execute(name);
        optional.ifPresent(this::throwUniqueConstraintExceptionForName);
    }

    private void throwUniqueConstraintExceptionForName(final File file) {
        throw new UniqueConstraintException("validation.file.name.already.exists", file.getName());
    }
}

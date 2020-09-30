package io.github.jtsato.bookstore.core.file.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.GetFileByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.file.gateway.UpdateFileByIdGateway;
import io.github.jtsato.bookstore.core.file.usecase.UpdateFileByIdUseCase;
import io.github.jtsato.bookstore.core.file.usecase.parameter.UpdateFileByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDate;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
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
public class UpdateFileByIdUseCaseImpl implements UpdateFileByIdUseCase {

    private final UpdateFileByIdGateway updateFileByIdGateway;

    private final GetFileByNameIgnoreCaseGateway getFileByNameIgnoreCaseGateway;

    private final GetLocalDate getLocalDate;

    @Override
    public File execute(final UpdateFileByIdParameters parameters) {

        checkDuplicatedNameViolation(parameters.getId(), parameters.getName());

        final Long id = parameters.getId();
        final Long size = parameters.getSize();
        final String contentType = StringUtils.stripToEmpty(parameters.getContentType());
        final String extension = StringUtils.stripToEmpty(parameters.getExtension());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String content = StringUtils.stripToEmpty(parameters.getContent());
        final String url = StringUtils.stripToEmpty(parameters.getUrl());
        final LocalDate creationDate = getLocalDate.now();
        final LocalDate lastModifiedDate = getLocalDate.now();

        final File file = new File(id ,
                                   size,
                                   contentType,
                                   extension,
                                   name,
                                   content,
                                   url,
                                   creationDate,
                                   lastModifiedDate);

        final Optional<File> optional = updateFileByIdGateway.execute(file);
        return optional.orElseThrow(() -> new NotFoundException("validation.file.id.notfound", String.valueOf(parameters.getId())));
    }

    private void checkDuplicatedNameViolation(final Long id, final String name) {

        final Optional<File> optional = getFileByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final File file = optional.get();
        if (!file.getId().equals(id)) {
            throw new UniqueConstraintException("validation.file.name.already.exists", file.getName());
        }
    }
}

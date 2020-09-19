package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Gender;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.author.gateway.UpdateAuthorByIdGateway;
import io.github.jtsato.bookstore.core.author.usecase.UpdateAuthorByIdUseCase;
import io.github.jtsato.bookstore.core.author.usecase.parameter.UpdateAuthorByIdParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
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
public class UpdateAuthorByIdUseCaseImpl implements UpdateAuthorByIdUseCase {

    private final UpdateAuthorByIdGateway updateAuthorByIdGateway;

    private final GetAuthorByNameIgnoreCaseGateway getAuthorByNameIgnoreCaseGateway;

    @Override
    public Author execute(final UpdateAuthorByIdParameters parameters) {

        checkDuplicatedNameViolation(parameters.getId(), parameters.getName());

        final Long id = parameters.getId();
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final Gender gender = EnumeratorUtils.valueOf(parameters.getGender(), Gender.class);
        final LocalDate birthdate = LocalDate.parse(parameters.getBirthdate());

        final Author author = new Author(id ,
                                         name,
                                         gender,
                                         birthdate);

        final Optional<Author> optional = updateAuthorByIdGateway.execute(author);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.id.notfound", String.valueOf(parameters.getId())));
    }

    private void checkDuplicatedNameViolation(final Long id, final String name) {

        final Optional<Author> optional = getAuthorByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final Author author = optional.get();
        if (!author.getId().equals(id)) {
            throw new UniqueConstraintException("validation.author.name.already.exists", author.getName());
        }
    }
}

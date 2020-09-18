  package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Gender;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.author.gateway.RegisterAuthorGateway;
import io.github.jtsato.bookstore.core.author.usecase.RegisterAuthorUseCase;
import io.github.jtsato.bookstore.core.author.usecase.parameter.RegisterAuthorParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
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
public class RegisterAuthorUseCaseImpl implements RegisterAuthorUseCase {

    private final RegisterAuthorGateway registerAuthorGateway;

    private final GetAuthorByNameIgnoreCaseGateway getAuthorByNameIgnoreCaseGateway;

    @Override
    public Author execute(final RegisterAuthorParameters parameters) {

        checkDuplicatedNameViolation(parameters.getName());

        final String name = StringUtils.stripToEmpty(parameters.getName());
        final Gender gender = EnumeratorUtils.valueOf(parameters.getGender(), Gender.class);
        final LocalDate birthdate = LocalDate.parse(parameters.getBirthdate());

        final Author author = new Author(null,
                                         name,
                                         gender,
                                         birthdate);

        return registerAuthorGateway.execute(author);
    }

    private void checkDuplicatedNameViolation(final String name) {
        final Optional<Author> optional = getAuthorByNameIgnoreCaseGateway.execute(name);
        optional.ifPresent(this::throwUniqueConstraintExceptionForName);
    }

    private void throwUniqueConstraintExceptionForName(final Author author) {
        throw new UniqueConstraintException("validation.author.name.already.exists", author.getName());
    }
}

  package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Gender;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.author.gateway.UpdateAuthorByAKeyGateway;
import io.github.jtsato.bookstore.core.author.usecase.UpdateAuthorByAKeyUseCase;
import io.github.jtsato.bookstore.core.author.usecase.parameter.UpdateAuthorByAKeyParameters;
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
public class UpdateAuthorByAKeyUseCaseImpl implements UpdateAuthorByAKeyUseCase {

    private final UpdateAuthorByAKeyGateway updateAuthorByAKeyGateway;

    private final GetAuthorByNameIgnoreCaseGateway getAuthorByNameIgnoreCaseGateway;

    @Override
    public Author execute(final UpdateAuthorByAKeyParameters parameters) {

        checkDuplicatedNameViolation(parameters.getAKey(), parameters.getName());

        final Long AKey = parameters.getAKey();
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final Gender gender = EnumeratorUtils.valueOf(parameters.getGender(), Gender.class);
        final LocalDate birthdate = LocalDate.parse(parameters.getBirthdate());

        final Author author = new Author(AKey ,
                                         name,
                                         gender,
                                         birthdate);

        final Optional<Author> optional = updateAuthorByAKeyGateway.execute(author);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.a.key.notfound", String.valueOf(parameters.getAKey())));
    }

    private void checkDuplicatedNameViolation(final Long aKey, final String name) {

        final Optional<Author> optional = getAuthorByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final Author author = optional.get();
        if (!author.getAKey().equals(aKey)) {
            throw new UniqueConstraintException("validation.author.name.already.exists", author.getName());
        }
    }
}

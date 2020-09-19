package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.author.domain.Gender;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.author.gateway.UpdateAuthorByAaKeyGateway;
import io.github.jtsato.bookstore.core.author.usecase.UpdateAuthorByAaKeyUseCase;
import io.github.jtsato.bookstore.core.author.usecase.parameter.UpdateAuthorByAaKeyParameters;
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
public class UpdateAuthorByAaKeyUseCaseImpl implements UpdateAuthorByAaKeyUseCase {

    private final UpdateAuthorByAaKeyGateway updateAuthorByAaKeyGateway;

    private final GetAuthorByNameIgnoreCaseGateway getAuthorByNameIgnoreCaseGateway;

    @Override
    public Author execute(final UpdateAuthorByAaKeyParameters parameters) {

        checkDuplicatedNameViolation(parameters.getAaKey(), parameters.getName());

        final Long aaKey = parameters.getAaKey();
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final Gender gender = EnumeratorUtils.valueOf(parameters.getGender(), Gender.class);
        final LocalDate birthdate = LocalDate.parse(parameters.getBirthdate());

        final Author author = new Author(aaKey ,
                                         name,
                                         gender,
                                         birthdate);

        final Optional<Author> optional = updateAuthorByAaKeyGateway.execute(author);
        return optional.orElseThrow(() -> new NotFoundException("validation.author.aa.key.notfound", String.valueOf(parameters.getAaKey())));
    }

    private void checkDuplicatedNameViolation(final Long aaKey, final String name) {

        final Optional<Author> optional = getAuthorByNameIgnoreCaseGateway.execute(name);

        if (optional.isEmpty()) {
            return;
        }

        final Author author = optional.get();
        if (!author.getAaKey().equals(aaKey)) {
            throw new UniqueConstraintException("validation.author.name.already.exists", author.getName());
        }
    }
}

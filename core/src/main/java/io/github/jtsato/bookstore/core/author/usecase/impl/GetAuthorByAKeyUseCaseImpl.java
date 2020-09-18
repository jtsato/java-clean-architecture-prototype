  package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByAKeyGateway;
import io.github.jtsato.bookstore.core.author.usecase.GetAuthorByAKeyUseCase;
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
public class GetAuthorByAKeyUseCaseImpl implements GetAuthorByAKeyUseCase {

    private final GetAuthorByAKeyGateway getAuthorByAKeyGateway;

    @Override
    public Author execute(final Long aKey) {

        if (aKey == null) {
            throw new InvalidParameterException("validation.author.a.key.null");
        }

        final Optional<Author> optional = getAuthorByAKeyGateway.execute(aKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.author.a.key.notfound", String.valueOf(aKey)));
    }
}

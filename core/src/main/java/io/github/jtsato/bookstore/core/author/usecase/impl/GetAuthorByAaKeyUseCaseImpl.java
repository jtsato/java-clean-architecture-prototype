package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByAaKeyGateway;
import io.github.jtsato.bookstore.core.author.usecase.GetAuthorByAaKeyUseCase;
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
public class GetAuthorByAaKeyUseCaseImpl implements GetAuthorByAaKeyUseCase {

    private final GetAuthorByAaKeyGateway getAuthorByAaKeyGateway;

    @Override
    public Author execute(final Long aaKey) {

        if (aaKey == null) {
            throw new InvalidParameterException("validation.author.aa.key.null");
        }

        final Optional<Author> optional = getAuthorByAaKeyGateway.execute(aaKey);

        return optional.orElseThrow(() -> new NotFoundException("validation.author.aa.key.notfound", String.valueOf(aaKey)));
    }
}

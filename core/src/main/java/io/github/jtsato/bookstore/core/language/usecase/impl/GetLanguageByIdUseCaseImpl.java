package io.github.jtsato.bookstore.core.language.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.GetLanguageByIdGateway;
import io.github.jtsato.bookstore.core.language.usecase.GetLanguageByIdUseCase;
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
public class GetLanguageByIdUseCaseImpl implements GetLanguageByIdUseCase {

    private final GetLanguageByIdGateway getLanguageByIdGateway;

    @Override
    public Language execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.language.id.null");
        }
        final Optional<Language> optional = getLanguageByIdGateway.execute(id);
        return optional.orElseThrow(() -> new NotFoundException("validation.language.id.notfound", String.valueOf(id)));
    }
}

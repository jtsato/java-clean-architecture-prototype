package io.github.jtsato.bookstore.core.language.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.UpdateLanguageByIdGateway;
import io.github.jtsato.bookstore.core.language.usecase.UpdateLanguageByIdUseCase;
import io.github.jtsato.bookstore.core.language.usecase.parameter.UpdateLanguageByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
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
public class UpdateLanguageByIdUseCaseImpl implements UpdateLanguageByIdUseCase {

    private final UpdateLanguageByIdGateway updateLanguageByIdGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Language execute(final UpdateLanguageByIdParameters parameters) {

        final Long id = parameters.getId();
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Language language = new Language(id ,
                                               name,
                                               null,
                                               lastModifiedDateTime);

        final Optional<Language> optional = updateLanguageByIdGateway.execute(language);
        return optional.orElseThrow(() -> new NotFoundException("validation.language.id.notfound", String.valueOf(parameters.getId())));
    }
}

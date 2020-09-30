package io.github.jtsato.bookstore.core.language.usecase.impl;

import java.time.LocalDateTime;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.RegisterLanguageGateway;
import io.github.jtsato.bookstore.core.language.usecase.RegisterLanguageUseCase;
import io.github.jtsato.bookstore.core.language.usecase.parameter.RegisterLanguageParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
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
public class RegisterLanguageUseCaseImpl implements RegisterLanguageUseCase {

    private final RegisterLanguageGateway registerLanguageGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Language execute(final RegisterLanguageParameters parameters) {

        final String name = StringUtils.stripToEmpty(parameters.getName());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final Language language = new Language(null,
                                               name,
                                               createdDateTime,
                                               lastModifiedDateTime);

        return registerLanguageGateway.execute(language);
    }
}

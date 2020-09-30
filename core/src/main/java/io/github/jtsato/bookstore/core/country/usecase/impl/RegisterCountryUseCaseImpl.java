package io.github.jtsato.bookstore.core.country.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.GetLanguageByIdGateway;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.RegisterCountryGateway;
import io.github.jtsato.bookstore.core.country.usecase.RegisterCountryUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.RegisterCountryParameters;
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
public class RegisterCountryUseCaseImpl implements RegisterCountryUseCase {

    private final RegisterCountryGateway registerCountryGateway;

    private final GetLanguageByIdGateway getLanguageByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Country execute(final RegisterCountryParameters parameters) {

        final Language language = getLanguageAndValidate(parameters.getLanguageId());

        final String name = StringUtils.stripToEmpty(parameters.getName());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final Country country = new Country(null,
                                            language,
                                            name,
                                            createdDateTime,
                                            lastModifiedDateTime);

        return registerCountryGateway.execute(country);
    }

    private Language getLanguageAndValidate(final Long languageId) {
        final Optional<Language> optional = getLanguageByIdGateway.execute(languageId);
        return optional.orElseThrow(() -> new NotFoundException("validation.language.id.notfound", String.valueOf(languageId)));
    }
}

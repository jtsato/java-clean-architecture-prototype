package io.github.jtsato.bookstore.core.country.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.GetLanguageByIdGateway;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.UpdateCountryByIdGateway;
import io.github.jtsato.bookstore.core.country.usecase.UpdateCountryByIdUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.UpdateCountryByIdParameters;
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
public class UpdateCountryByIdUseCaseImpl implements UpdateCountryByIdUseCase {

    private final UpdateCountryByIdGateway updateCountryByIdGateway;

    private final GetLanguageByIdGateway getLanguageByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Country execute(final UpdateCountryByIdParameters parameters) {
        final Language language = getLanguageAndValidate(parameters.getLanguageId());

        final Long id = parameters.getId();
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Country country = new Country(id ,
                                            language,
                                            name,
                                            null,
                                            lastModifiedDateTime);

        final Optional<Country> optional = updateCountryByIdGateway.execute(country);
        return optional.orElseThrow(() -> new NotFoundException("validation.country.id.notfound", String.valueOf(parameters.getId())));
    }

    private Language getLanguageAndValidate(final Long languageId) {
        final Optional<Language> optional = getLanguageByIdGateway.execute(languageId);
        return optional.orElseThrow(() -> new NotFoundException("validation.language.id.notfound", String.valueOf(languageId)));
    }
}

package io.github.jtsato.bookstore.core.language.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.RemoveLanguageByIdGateway;
import io.github.jtsato.bookstore.core.language.usecase.RemoveLanguageByIdUseCase;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.SearchCountriesByLanguageIdGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.ParentConstraintException;
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
public class RemoveLanguageByIdUseCaseImpl implements RemoveLanguageByIdUseCase {

    private final RemoveLanguageByIdGateway removeLanguageByIdGateway;

    private final SearchCountriesByLanguageIdGateway searchCountriesByLanguageIdGateway;

    @Override
    public Language execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.language.id.null");
        }

        avoidRemovingLanguageWithCountries(id);

        final Optional<Language> optional = removeLanguageByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.language.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingLanguageWithCountries(final Long id) {

        final Page<Country> pageOfCountries = searchCountriesByLanguageIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfCountries.getContent())) {
            throw new ParentConstraintException("validation.language.with.countries.removal");
        }
    }
}

package io.github.jtsato.bookstore.core.language.usecase.impl;

import javax.inject.Named;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.SearchLanguagesGateway;
import io.github.jtsato.bookstore.core.language.usecase.SearchLanguagesUseCase;
import io.github.jtsato.bookstore.core.language.usecase.parameter.SearchLanguagesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
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
public class SearchLanguagesUseCaseImpl implements SearchLanguagesUseCase {

    private final SearchLanguagesGateway searchLanguagesGateway;

    @Override
    public Page<Language> execute(final SearchLanguagesParameters parameters, final Integer page, final Integer size, final String orderBy) {
        return searchLanguagesGateway.execute(parameters, page, size, orderBy);
    }
}

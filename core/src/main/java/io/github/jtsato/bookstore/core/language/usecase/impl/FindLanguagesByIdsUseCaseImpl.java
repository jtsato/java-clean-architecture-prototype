package io.github.jtsato.bookstore.core.language.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.gateway.FindLanguagesByIdsGateway;
import io.github.jtsato.bookstore.core.language.usecase.FindLanguagesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
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
public class FindLanguagesByIdsUseCaseImpl implements FindLanguagesByIdsUseCase {

    private final FindLanguagesByIdsGateway findLanguagesByIdsGateway;

    @Override
    public Page<Language> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.language.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findLanguagesByIdsGateway.execute(ids);
    }
}

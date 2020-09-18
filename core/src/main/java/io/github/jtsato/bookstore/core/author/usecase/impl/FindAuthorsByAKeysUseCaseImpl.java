  package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.FindAuthorsByAKeysGateway;
import io.github.jtsato.bookstore.core.author.usecase.FindAuthorsByAKeysUseCase;
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
public class FindAuthorsByAKeysUseCaseImpl implements FindAuthorsByAKeysUseCase {

    private final FindAuthorsByAKeysGateway findAuthorsByAKeysGateway;

    @Override
    public Page<Author> execute(final List<Long> aKeys) {

        if (CollectionUtils.isEmpty(aKeys)) {
            throw new InvalidParameterException("validation.author.a.keys.null");
        }

        if (aKeys.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.a.keys.limit");
        }

        return findAuthorsByAKeysGateway.execute(aKeys);
    }
}

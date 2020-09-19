package io.github.jtsato.bookstore.core.author.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.FindAuthorsByAaKeysGateway;
import io.github.jtsato.bookstore.core.author.usecase.FindAuthorsByAaKeysUseCase;
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
public class FindAuthorsByAaKeysUseCaseImpl implements FindAuthorsByAaKeysUseCase {

    private final FindAuthorsByAaKeysGateway findAuthorsByAaKeysGateway;

    @Override
    public Page<Author> execute(final List<Long> aaKeys) {

        if (CollectionUtils.isEmpty(aaKeys)) {
            throw new InvalidParameterException("validation.author.aa.keys.null");
        }

        if (aaKeys.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.aa.keys.limit");
        }

        return findAuthorsByAaKeysGateway.execute(aaKeys);
    }
}

package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.FindBooksByBKeysGateway;
import io.github.jtsato.bookstore.core.book.usecase.FindBooksByBKeysUseCase;
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
public class FindBooksByBKeysUseCaseImpl implements FindBooksByBKeysUseCase {

    private final FindBooksByBKeysGateway findBooksByBKeysGateway;

    @Override
    public Page<Book> execute(final List<Long> bKeys) {

        if (CollectionUtils.isEmpty(bKeys)) {
            throw new InvalidParameterException("validation.book.b.keys.null");
        }

        if (bKeys.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.b.keys.limit");
        }

        return findBooksByBKeysGateway.execute(bKeys);
    }
}

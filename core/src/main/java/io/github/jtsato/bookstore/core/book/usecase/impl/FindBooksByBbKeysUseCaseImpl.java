package io.github.jtsato.bookstore.core.book.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.FindBooksByBbKeysGateway;
import io.github.jtsato.bookstore.core.book.usecase.FindBooksByBbKeysUseCase;
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
public class FindBooksByBbKeysUseCaseImpl implements FindBooksByBbKeysUseCase {

    private final FindBooksByBbKeysGateway findBooksByBbKeysGateway;

    @Override
    public Page<Book> execute(final List<Long> bbKeys) {

        if (CollectionUtils.isEmpty(bbKeys)) {
            throw new InvalidParameterException("validation.book.bb.keys.null");
        }

        if (bbKeys.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.bb.keys.limit");
        }

        return findBooksByBbKeysGateway.execute(bbKeys);
    }
}

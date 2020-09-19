package io.github.jtsato.bookstore.core.book.usecase;

import io.github.jtsato.bookstore.core.book.domain.Book;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetBookByBbKeyUseCase {

    Book execute(final Long BbKey);
}

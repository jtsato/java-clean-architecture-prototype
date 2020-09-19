package io.github.jtsato.bookstore.core.book.usecase;

import io.github.jtsato.bookstore.core.book.domain.Book;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveBookByBbKeyUseCase {

    Book execute(final Long BbKey);
}

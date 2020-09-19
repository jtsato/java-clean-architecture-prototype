package io.github.jtsato.bookstore.core.book.usecase;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.usecase.parameter.UpdateBookByBbKeyParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateBookByBbKeyUseCase {

    Book execute(final UpdateBookByBbKeyParameters parameters);
}

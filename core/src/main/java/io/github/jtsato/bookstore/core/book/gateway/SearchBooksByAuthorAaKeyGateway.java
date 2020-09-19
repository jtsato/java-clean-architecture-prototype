package io.github.jtsato.bookstore.core.book.gateway;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchBooksByAuthorAaKeyGateway {

    Page<Book> execute(final Long authorAaKey, final Integer pageNumber, final Integer size, final String orderBy);
}

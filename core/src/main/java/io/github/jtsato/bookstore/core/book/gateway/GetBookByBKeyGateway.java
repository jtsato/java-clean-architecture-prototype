package io.github.jtsato.bookstore.core.book.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.book.domain.Book;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetBookByBKeyGateway {

    Optional<Book> execute(final Long BKey);
}

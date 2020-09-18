package io.github.jtsato.bookstore.core.author.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.author.domain.Author;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetAuthorByAKeyGateway {

    Optional<Author> execute(final Long AKey);
}

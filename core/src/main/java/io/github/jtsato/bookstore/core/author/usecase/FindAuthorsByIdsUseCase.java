package io.github.jtsato.bookstore.core.author.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindAuthorsByIdsUseCase {

    Page<Author> execute(final List<Long> ids);
}

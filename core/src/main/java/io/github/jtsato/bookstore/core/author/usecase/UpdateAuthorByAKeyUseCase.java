package io.github.jtsato.bookstore.core.author.usecase;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.usecase.parameter.UpdateAuthorByAKeyParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateAuthorByAKeyUseCase {

    Author execute(final UpdateAuthorByAKeyParameters parameters);
}

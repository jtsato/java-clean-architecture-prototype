package io.github.jtsato.bookstore.core.language.usecase;

import io.github.jtsato.bookstore.core.language.domain.Language;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetLanguageByIdUseCase {

    Language execute(final Long Id);
}

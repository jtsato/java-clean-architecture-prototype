package io.github.jtsato.bookstore.core.language.usecase;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.usecase.parameter.RegisterLanguageParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterLanguageUseCase {

    Language execute(final RegisterLanguageParameters parameters);
}

package io.github.jtsato.bookstore.core.language.usecase;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.usecase.parameter.UpdateLanguageByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateLanguageByIdUseCase {

    Language execute(final UpdateLanguageByIdParameters parameters);
}

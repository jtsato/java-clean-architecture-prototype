package io.github.jtsato.bookstore.core.language.usecase;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.language.usecase.parameter.SearchLanguagesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchLanguagesUseCase {

    Page<Language> execute(final SearchLanguagesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

package io.github.jtsato.bookstore.core.language.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.language.domain.Language;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveLanguageByIdGateway {

    Optional<Language> execute(final Long Id);
}

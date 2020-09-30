package io.github.jtsato.bookstore.core.language.gateway;

import io.github.jtsato.bookstore.core.language.domain.Language;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterLanguageGateway {

    Language execute(final Language language);
}

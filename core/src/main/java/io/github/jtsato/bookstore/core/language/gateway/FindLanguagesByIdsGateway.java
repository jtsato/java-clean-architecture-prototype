package io.github.jtsato.bookstore.core.language.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.language.domain.Language;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindLanguagesByIdsGateway {

    Page<Language> execute(final List<Long> ids);
}

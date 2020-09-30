package io.github.jtsato.bookstore.core.file.gateway;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.parameter.SearchFilesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchFilesGateway {

    Page<File> execute(final SearchFilesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

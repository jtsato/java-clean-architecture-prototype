package io.github.jtsato.bookstore.core.education.gateway;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.usecase.parameter.SearchEducationsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchEducationsGateway {

    Page<Education> execute(final SearchEducationsParameters parameters, final Integer page, final Integer size, final String orderBy);
}

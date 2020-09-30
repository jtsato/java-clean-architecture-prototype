package io.github.jtsato.bookstore.core.lead.gateway;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchLeadsGateway {

    Page<Lead> execute(final SearchLeadsParameters parameters, final Integer page, final Integer size, final String orderBy);
}

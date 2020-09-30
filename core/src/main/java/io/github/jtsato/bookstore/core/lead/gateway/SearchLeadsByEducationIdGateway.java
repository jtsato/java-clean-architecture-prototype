package io.github.jtsato.bookstore.core.lead.gateway;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchLeadsByEducationIdGateway {

    Page<Lead> execute(final Long educationId, final Integer pageNumber, final Integer size, final String orderBy);
}

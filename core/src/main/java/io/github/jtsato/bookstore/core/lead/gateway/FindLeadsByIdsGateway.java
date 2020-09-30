package io.github.jtsato.bookstore.core.lead.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindLeadsByIdsGateway {

    Page<Lead> execute(final List<Long> ids);
}

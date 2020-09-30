package io.github.jtsato.bookstore.core.lead.gateway;

import io.github.jtsato.bookstore.core.lead.domain.Lead;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterLeadGateway {

    Lead execute(final Lead lead);
}

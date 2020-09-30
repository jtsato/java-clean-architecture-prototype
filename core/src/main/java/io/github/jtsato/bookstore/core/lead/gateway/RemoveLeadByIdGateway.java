package io.github.jtsato.bookstore.core.lead.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.lead.domain.Lead;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveLeadByIdGateway {

    Optional<Lead> execute(final Long Id);
}

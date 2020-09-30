package io.github.jtsato.bookstore.core.lead.usecase;

import io.github.jtsato.bookstore.core.lead.domain.Lead;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveLeadByIdUseCase {

    Lead execute(final Long Id);
}

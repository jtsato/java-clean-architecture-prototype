package io.github.jtsato.bookstore.core.lead.usecase;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.UpdateLeadByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateLeadByIdUseCase {

    Lead execute(final UpdateLeadByIdParameters parameters);
}

package io.github.jtsato.bookstore.core.lead.usecase;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.RegisterLeadParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterLeadUseCase {

    Lead execute(final RegisterLeadParameters parameters);
}

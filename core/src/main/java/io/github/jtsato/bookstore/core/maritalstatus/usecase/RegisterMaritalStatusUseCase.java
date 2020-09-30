package io.github.jtsato.bookstore.core.maritalstatus.usecase;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter.RegisterMaritalStatusParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterMaritalStatusUseCase {

    MaritalStatus execute(final RegisterMaritalStatusParameters parameters);
}

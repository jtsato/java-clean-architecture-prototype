package io.github.jtsato.bookstore.core.maritalstatus.usecase;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter.UpdateMaritalStatusByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateMaritalStatusByIdUseCase {

    MaritalStatus execute(final UpdateMaritalStatusByIdParameters parameters);
}

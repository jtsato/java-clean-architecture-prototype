package io.github.jtsato.bookstore.core.maritalstatus.usecase;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetMaritalStatusByIdUseCase {

    MaritalStatus execute(final Long Id);
}

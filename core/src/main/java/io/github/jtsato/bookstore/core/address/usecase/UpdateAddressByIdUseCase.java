package io.github.jtsato.bookstore.core.address.usecase;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.parameter.UpdateAddressByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateAddressByIdUseCase {

    Address execute(final UpdateAddressByIdParameters parameters);
}

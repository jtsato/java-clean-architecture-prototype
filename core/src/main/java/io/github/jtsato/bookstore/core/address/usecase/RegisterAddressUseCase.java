package io.github.jtsato.bookstore.core.address.usecase;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.parameter.RegisterAddressParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterAddressUseCase {

    Address execute(final RegisterAddressParameters parameters);
}

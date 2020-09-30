package io.github.jtsato.bookstore.core.address.usecase;

import io.github.jtsato.bookstore.core.address.domain.Address;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetAddressByIdUseCase {

    Address execute(final Long Id);
}

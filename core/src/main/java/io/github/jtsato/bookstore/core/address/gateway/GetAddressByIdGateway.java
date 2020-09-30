package io.github.jtsato.bookstore.core.address.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.address.domain.Address;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetAddressByIdGateway {

    Optional<Address> execute(final Long Id);
}
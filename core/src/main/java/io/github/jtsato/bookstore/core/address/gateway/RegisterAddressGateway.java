package io.github.jtsato.bookstore.core.address.gateway;

import io.github.jtsato.bookstore.core.address.domain.Address;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterAddressGateway {

    Address execute(final Address address);
}

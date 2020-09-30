package io.github.jtsato.bookstore.core.address.gateway;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.parameter.SearchAddressesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchAddressesGateway {

    Page<Address> execute(final SearchAddressesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

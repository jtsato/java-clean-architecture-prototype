package io.github.jtsato.bookstore.core.address.usecase;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.parameter.SearchAddressesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchAddressesUseCase {

    Page<Address> execute(final SearchAddressesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

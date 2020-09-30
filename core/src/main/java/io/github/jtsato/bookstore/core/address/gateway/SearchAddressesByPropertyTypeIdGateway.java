package io.github.jtsato.bookstore.core.address.gateway;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchAddressesByPropertyTypeIdGateway {

    Page<Address> execute(final Long propertyTypeId, final Integer pageNumber, final Integer size, final String orderBy);
}

package io.github.jtsato.bookstore.core.propertytype.gateway;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchPropertyTypesByCountryIdGateway {

    Page<PropertyType> execute(final Long countryId, final Integer pageNumber, final Integer size, final String orderBy);
}

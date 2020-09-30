package io.github.jtsato.bookstore.core.propertytype.gateway;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.usecase.parameter.SearchPropertyTypesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchPropertyTypesGateway {

    Page<PropertyType> execute(final SearchPropertyTypesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

package io.github.jtsato.bookstore.core.propertytype.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindPropertyTypesByIdsGateway {

    Page<PropertyType> execute(final List<Long> ids);
}

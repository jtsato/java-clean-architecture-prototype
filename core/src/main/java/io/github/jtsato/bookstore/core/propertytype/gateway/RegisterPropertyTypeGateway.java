package io.github.jtsato.bookstore.core.propertytype.gateway;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterPropertyTypeGateway {

    PropertyType execute(final PropertyType propertyType);
}

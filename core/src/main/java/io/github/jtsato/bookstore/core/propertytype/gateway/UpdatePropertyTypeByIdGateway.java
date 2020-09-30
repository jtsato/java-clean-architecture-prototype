package io.github.jtsato.bookstore.core.propertytype.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdatePropertyTypeByIdGateway {

    Optional<PropertyType> execute(final PropertyType propertyType);
}

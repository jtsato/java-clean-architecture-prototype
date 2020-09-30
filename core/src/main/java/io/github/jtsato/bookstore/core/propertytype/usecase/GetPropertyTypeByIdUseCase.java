package io.github.jtsato.bookstore.core.propertytype.usecase;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetPropertyTypeByIdUseCase {

    PropertyType execute(final Long Id);
}

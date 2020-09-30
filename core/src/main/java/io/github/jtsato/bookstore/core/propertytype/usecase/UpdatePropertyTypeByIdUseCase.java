package io.github.jtsato.bookstore.core.propertytype.usecase;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.usecase.parameter.UpdatePropertyTypeByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdatePropertyTypeByIdUseCase {

    PropertyType execute(final UpdatePropertyTypeByIdParameters parameters);
}

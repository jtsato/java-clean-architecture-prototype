package io.github.jtsato.bookstore.core.propertytype.usecase;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.usecase.parameter.RegisterPropertyTypeParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterPropertyTypeUseCase {

    PropertyType execute(final RegisterPropertyTypeParameters parameters);
}

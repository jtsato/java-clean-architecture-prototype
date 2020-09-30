package io.github.jtsato.bookstore.core.propertytype.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindPropertyTypesByIdsUseCase {

    Page<PropertyType> execute(final List<Long> ids);
}

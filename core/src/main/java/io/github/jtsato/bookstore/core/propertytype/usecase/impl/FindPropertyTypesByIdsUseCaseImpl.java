package io.github.jtsato.bookstore.core.propertytype.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.propertytype.domain.PropertyType;
import io.github.jtsato.bookstore.core.propertytype.gateway.FindPropertyTypesByIdsGateway;
import io.github.jtsato.bookstore.core.propertytype.usecase.FindPropertyTypesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import lombok.RequiredArgsConstructor;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */

/**
 * @author Jorge Takeshi Sato
 */

@Named
@RequiredArgsConstructor
public class FindPropertyTypesByIdsUseCaseImpl implements FindPropertyTypesByIdsUseCase {

    private final FindPropertyTypesByIdsGateway findPropertyTypesByIdsGateway;

    @Override
    public Page<PropertyType> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.property.type.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findPropertyTypesByIdsGateway.execute(ids);
    }
}

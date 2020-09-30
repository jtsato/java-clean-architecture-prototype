package io.github.jtsato.bookstore.core.address.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.FindAddressesByIdsGateway;
import io.github.jtsato.bookstore.core.address.usecase.FindAddressesByIdsUseCase;
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
public class FindAddressesByIdsUseCaseImpl implements FindAddressesByIdsUseCase {

    private final FindAddressesByIdsGateway findAddressesByIdsGateway;

    @Override
    public Page<Address> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.address.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findAddressesByIdsGateway.execute(ids);
    }
}

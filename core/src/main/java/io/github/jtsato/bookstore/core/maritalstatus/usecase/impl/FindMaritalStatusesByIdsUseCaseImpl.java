package io.github.jtsato.bookstore.core.maritalstatus.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.gateway.FindMaritalStatusesByIdsGateway;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.FindMaritalStatusesByIdsUseCase;
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
public class FindMaritalStatusesByIdsUseCaseImpl implements FindMaritalStatusesByIdsUseCase {

    private final FindMaritalStatusesByIdsGateway findMaritalStatusesByIdsGateway;

    @Override
    public Page<MaritalStatus> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.marital.status.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findMaritalStatusesByIdsGateway.execute(ids);
    }
}

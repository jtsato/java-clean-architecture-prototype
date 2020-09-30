package io.github.jtsato.bookstore.core.education.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.gateway.FindEducationsByIdsGateway;
import io.github.jtsato.bookstore.core.education.usecase.FindEducationsByIdsUseCase;
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
public class FindEducationsByIdsUseCaseImpl implements FindEducationsByIdsUseCase {

    private final FindEducationsByIdsGateway findEducationsByIdsGateway;

    @Override
    public Page<Education> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.education.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findEducationsByIdsGateway.execute(ids);
    }
}

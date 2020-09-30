package io.github.jtsato.bookstore.core.jobinformation.usecase.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.FindJobInformationsByIdsGateway;
import io.github.jtsato.bookstore.core.jobinformation.usecase.FindJobInformationsByIdsUseCase;
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
public class FindJobInformationsByIdsUseCaseImpl implements FindJobInformationsByIdsUseCase {

    private final FindJobInformationsByIdsGateway findJobInformationsByIdsGateway;

    @Override
    public Page<JobInformation> execute(final List<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            throw new InvalidParameterException("validation.job.information.ids.null");
        }

        if (ids.size() > 1000) {
            throw new InvalidParameterException("validation.get.by.ids.limit");
        }

        return findJobInformationsByIdsGateway.execute(ids);
    }
}

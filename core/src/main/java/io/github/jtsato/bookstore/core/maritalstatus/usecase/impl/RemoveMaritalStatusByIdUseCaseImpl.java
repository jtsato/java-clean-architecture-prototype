package io.github.jtsato.bookstore.core.maritalstatus.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.gateway.RemoveMaritalStatusByIdGateway;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.RemoveMaritalStatusByIdUseCase;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.SearchLeadsByMaritalStatusIdGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.ParentConstraintException;
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
public class RemoveMaritalStatusByIdUseCaseImpl implements RemoveMaritalStatusByIdUseCase {

    private final RemoveMaritalStatusByIdGateway removeMaritalStatusByIdGateway;

    private final SearchLeadsByMaritalStatusIdGateway searchLeadsByMaritalStatusIdGateway;

    @Override
    public MaritalStatus execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.marital.status.id.null");
        }

        avoidRemovingMaritalStatusWithLeads(id);

        final Optional<MaritalStatus> optional = removeMaritalStatusByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.marital.status.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingMaritalStatusWithLeads(final Long id) {

        final Page<Lead> pageOfLeads = searchLeadsByMaritalStatusIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfLeads.getContent())) {
            throw new ParentConstraintException("validation.marital.status.with.leads.removal");
        }
    }
}

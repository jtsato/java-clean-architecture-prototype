package io.github.jtsato.bookstore.core.education.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.gateway.RemoveEducationByIdGateway;
import io.github.jtsato.bookstore.core.education.usecase.RemoveEducationByIdUseCase;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.SearchLeadsByEducationIdGateway;
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
public class RemoveEducationByIdUseCaseImpl implements RemoveEducationByIdUseCase {

    private final RemoveEducationByIdGateway removeEducationByIdGateway;

    private final SearchLeadsByEducationIdGateway searchLeadsByEducationIdGateway;

    @Override
    public Education execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.education.id.null");
        }

        avoidRemovingEducationWithLeads(id);

        final Optional<Education> optional = removeEducationByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.education.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingEducationWithLeads(final Long id) {

        final Page<Lead> pageOfLeads = searchLeadsByEducationIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfLeads.getContent())) {
            throw new ParentConstraintException("validation.education.with.leads.removal");
        }
    }
}

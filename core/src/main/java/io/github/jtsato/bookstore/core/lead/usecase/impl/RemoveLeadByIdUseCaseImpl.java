package io.github.jtsato.bookstore.core.lead.usecase.impl;

import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.RemoveLeadByIdGateway;
import io.github.jtsato.bookstore.core.lead.usecase.RemoveLeadByIdUseCase;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.SearchAddressesByLeadIdGateway;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.SearchDocumentsByLeadIdGateway;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.SearchJobInformationsByLeadIdGateway;
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
public class RemoveLeadByIdUseCaseImpl implements RemoveLeadByIdUseCase {

    private final RemoveLeadByIdGateway removeLeadByIdGateway;

    private final SearchAddressesByLeadIdGateway searchAddressesByLeadIdGateway;

    private final SearchDocumentsByLeadIdGateway searchDocumentsByLeadIdGateway;

    private final SearchJobInformationsByLeadIdGateway searchJobInformationsByLeadIdGateway;

    @Override
    public Lead execute(final Long id) {

        if (id == null) {
            throw new InvalidParameterException("validation.lead.id.null");
        }

        avoidRemovingLeadWithAddresses(id);

        avoidRemovingLeadWithDocuments(id);

        avoidRemovingLeadWithJobInformations(id);

        final Optional<Lead> optional = removeLeadByIdGateway.execute(id);

        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(id)));
    }

    private void avoidRemovingLeadWithAddresses(final Long id) {

        final Page<Address> pageOfAddresses = searchAddressesByLeadIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfAddresses.getContent())) {
            throw new ParentConstraintException("validation.lead.with.addresses.removal");
        }
    }

    private void avoidRemovingLeadWithDocuments(final Long id) {

        final Page<Document> pageOfDocuments = searchDocumentsByLeadIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfDocuments.getContent())) {
            throw new ParentConstraintException("validation.lead.with.documents.removal");
        }
    }

    private void avoidRemovingLeadWithJobInformations(final Long id) {

        final Page<JobInformation> pageOfJobInformations = searchJobInformationsByLeadIdGateway.execute(id, 0, 1, null);

        if (CollectionUtils.isNotEmpty(pageOfJobInformations.getContent())) {
            throw new ParentConstraintException("validation.lead.with.job.informations.removal");
        }
    }
}

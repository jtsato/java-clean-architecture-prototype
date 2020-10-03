package io.github.jtsato.bookstore.core.address.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.address.domain.PropertyType;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByIdGateway;
import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.UpdateAddressByIdGateway;
import io.github.jtsato.bookstore.core.address.usecase.UpdateAddressByIdUseCase;
import io.github.jtsato.bookstore.core.address.usecase.parameter.UpdateAddressByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
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
public class UpdateAddressByIdUseCaseImpl implements UpdateAddressByIdUseCase {

    private final UpdateAddressByIdGateway updateAddressByIdGateway;

    private final GetLeadByIdGateway getLeadByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Address execute(final UpdateAddressByIdParameters parameters) {

        final Lead lead = getLeadAndValidate(parameters.getLeadId());

        final Long id = parameters.getId();
        final String zipCode = StringUtils.stripToEmpty(parameters.getZipCode());
        final String city = StringUtils.stripToEmpty(parameters.getCity());
        final String state = StringUtils.stripToEmpty(parameters.getState());
        final String country = StringUtils.stripToEmpty(parameters.getCountry());
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final String complement = StringUtils.stripToEmpty(parameters.getComplement());
        final String number = StringUtils.stripToEmpty(parameters.getNumber());
        final PropertyType type = EnumeratorUtils.valueOf(parameters.getType(), PropertyType.class);
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Address address = new Address(id ,
                                            lead,
                                            zipCode,
                                            city,
                                            state,
                                            country,
                                            description,
                                            complement,
                                            number,
                                            type,
                                            null,
                                            lastModifiedDateTime);

        final Optional<Address> optional = updateAddressByIdGateway.execute(address);
        return optional.orElseThrow(() -> new NotFoundException("validation.address.id.notfound", String.valueOf(parameters.getId())));
    }

    private Lead getLeadAndValidate(final Long leadId) {
        final Optional<Lead> optional = getLeadByIdGateway.execute(leadId);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(leadId)));
    }
}

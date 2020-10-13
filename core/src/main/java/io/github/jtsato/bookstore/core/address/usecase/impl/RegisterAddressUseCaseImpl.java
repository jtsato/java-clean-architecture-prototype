package io.github.jtsato.bookstore.core.address.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.address.domain.PropertyType;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByIdGateway;
import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.RegisterAddressGateway;
import io.github.jtsato.bookstore.core.address.usecase.RegisterAddressUseCase;
import io.github.jtsato.bookstore.core.address.usecase.parameter.RegisterAddressParameters;
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
public class RegisterAddressUseCaseImpl implements RegisterAddressUseCase {

    private final RegisterAddressGateway registerAddressGateway;

    private final GetLeadByIdGateway getLeadByIdGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Address execute(final RegisterAddressParameters parameters) {

        final Lead lead = getLeadAndValidate(parameters.getLeadId());

        final String zipCode = StringUtils.stripToEmpty(parameters.getZipCode());
        final String city = StringUtils.stripToEmpty(parameters.getCity());
        final String state = StringUtils.stripToEmpty(parameters.getState());
        final String country = StringUtils.stripToEmpty(parameters.getCountry());
        final String description = StringUtils.stripToEmpty(parameters.getDescription());
        final String complement = StringUtils.stripToEmpty(parameters.getComplement());
        final String number = StringUtils.stripToEmpty(parameters.getNumber());
        final PropertyType propertyType = EnumeratorUtils.valueOf(parameters.getPropertyType(), PropertyType.class);
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Address address = new Address(null,
                                            lead,
                                            zipCode,
                                            city,
                                            state,
                                            country,
                                            description,
                                            complement,
                                            number,
                                            propertyType,
                                            createdDateTime,
                                            lastModifiedDateTime);

        return registerAddressGateway.execute(address);
    }

    private Lead getLeadAndValidate(final Long leadId) {
        final Optional<Lead> optional = getLeadByIdGateway.execute(leadId);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(leadId)));
    }
}

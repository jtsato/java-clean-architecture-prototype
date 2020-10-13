package io.github.jtsato.bookstore.entrypoint.rest.address.controller;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.parameter.SearchAddressesParameters;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.address.usecase.SearchAddressesUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.address.api.SearchAddressesApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.request.SearchAddressesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.request.SearchAddressesLeadRequest;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.SearchAddressesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.mapper.SearchAddressesPresenter;
import io.github.jtsato.bookstore.entrypoint.rest.common.JsonConverter;
import io.github.jtsato.bookstore.entrypoint.rest.common.metric.LogExecutionTime;
import lombok.RequiredArgsConstructor;

/*
 * A EntryPoint follows these steps:
 *
 * - Maps HTTP requests to Java objects
 * - Performs authorization checks
 * - Maps input to the input model of the use case
 * - Calls the use case
 * - Maps the output of the use case back to HTTP Returns an HTTP response
 */

/**
 * @author Jorge Takeshi Sato
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class SearchAddressesController implements SearchAddressesApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchAddressesController.class);

    private final SearchAddressesUseCase searchAddressesUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchAddressesWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchAddressesRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchAddressesController with {}", jsonRequest);

        final SearchAddressesParameters parameters = buildSearchAddressesParameters(request);
        final Page<Address> addresses = searchAddressesUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchAddressesPresenter.of(addresses);
    }

    private SearchAddressesParameters buildSearchAddressesParameters(final SearchAddressesRequest searchAddressesRequest) {

        final Long id = searchAddressesRequest.getId();
        final SearchLeadsParameters searchLeadsParameters = buildSearchLeadsParameters(searchAddressesRequest.getLead());
        final String zipCode = searchAddressesRequest.getZipCode();
        final String city = searchAddressesRequest.getCity();
        final String state = searchAddressesRequest.getState();
        final String country = searchAddressesRequest.getCountry();
        final String description = searchAddressesRequest.getDescription();
        final String complement = searchAddressesRequest.getComplement();
        final String number = searchAddressesRequest.getNumber();
        final String propertyType = searchAddressesRequest.getPropertyType();
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchAddressesRequest.getStartCreatedDateTime(), searchAddressesRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchAddressesRequest.getStartLastModifiedDateTime(), searchAddressesRequest.getEndLastModifiedDateTime());
        return new SearchAddressesParameters(id, searchLeadsParameters, zipCode, city, state, country, description, complement, number, propertyType, createdDateTimeRange, lastModifiedDateTimeRange); 
    }

    private SearchLeadsParameters buildSearchLeadsParameters(final SearchAddressesLeadRequest searchLeadsRequest) {

        final Long id = searchLeadsRequest.getId();
        final ImmutablePair<Long, Long> selfiePhotoRange = new ImmutablePair<>(searchLeadsRequest.getStartSelfiePhoto(), searchLeadsRequest.getEndSelfiePhoto());
        final String cpf = searchLeadsRequest.getCpf();
        final String cellphone = searchLeadsRequest.getCellphone();
        final String name = searchLeadsRequest.getName();
        final String motherFullName = searchLeadsRequest.getMotherFullName();
        final String gender = searchLeadsRequest.getGender();
        final String education = searchLeadsRequest.getEducation();
        final String maritalStatus = searchLeadsRequest.getMaritalStatus();
        final Boolean stableUnion = searchLeadsRequest.getStableUnion();
        final ImmutablePair<String, String> birthdateRange = new ImmutablePair<>(searchLeadsRequest.getStartBirthdate(), searchLeadsRequest.getEndBirthdate());
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchLeadsRequest.getStartCreatedDateTime(), searchLeadsRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchLeadsRequest.getStartLastModifiedDateTime(), searchLeadsRequest.getEndLastModifiedDateTime());
        return new SearchLeadsParameters(id, selfiePhotoRange, cpf, cellphone, name, motherFullName, gender, education, maritalStatus, stableUnion, birthdateRange, createdDateTimeRange, lastModifiedDateTimeRange); 
    }
}

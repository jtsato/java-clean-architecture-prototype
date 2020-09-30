package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.controller;

import java.math.BigDecimal;

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

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.SearchJobInformationsParameters;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.jobinformation.usecase.SearchJobInformationsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.api.SearchJobInformationsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request.SearchJobInformationsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request.SearchJobInformationsLeadRequest;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.SearchJobInformationsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper.SearchJobInformationsPresenter;
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
@RequestMapping("/job-informations")
public class SearchJobInformationsController implements SearchJobInformationsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchJobInformationsController.class);

    private final SearchJobInformationsUseCase searchJobInformationsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchJobInformationsWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchJobInformationsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchJobInformationsController with {}", jsonRequest);

        final SearchJobInformationsParameters parameters = buildSearchJobInformationsParameters(request);
        final Page<JobInformation> jobInformations = searchJobInformationsUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchJobInformationsPresenter.of(jobInformations);
    }

    private SearchJobInformationsParameters buildSearchJobInformationsParameters(final SearchJobInformationsRequest searchJobInformationsRequest) {

        final Long id = searchJobInformationsRequest.getId();
        final SearchLeadsParameters searchLeadsParameters = buildSearchLeadsParameters(searchJobInformationsRequest.getLead());
        final ImmutablePair<Long, Long> attachRange = new ImmutablePair<>(searchJobInformationsRequest.getStartAttach(), searchJobInformationsRequest.getEndAttach());
        final String profession = searchJobInformationsRequest.getProfession();
        final String referenceMonth = searchJobInformationsRequest.getReferenceMonth();
        final String receiptType = searchJobInformationsRequest.getReceiptType();
        final ImmutablePair<String, String> startDateRange = new ImmutablePair<>(searchJobInformationsRequest.getStartStartDate(), searchJobInformationsRequest.getEndStartDate());
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchJobInformationsRequest.getStartCreatedDateTime(), searchJobInformationsRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchJobInformationsRequest.getStartLastModifiedDateTime(), searchJobInformationsRequest.getEndLastModifiedDateTime());
        final ImmutablePair<BigDecimal, BigDecimal> monthlyIncomeRange = new ImmutablePair<>(searchJobInformationsRequest.getStartMonthlyIncome(), searchJobInformationsRequest.getEndMonthlyIncome());
        return new SearchJobInformationsParameters(id, searchLeadsParameters, attachRange, profession, referenceMonth, receiptType, startDateRange, createdDateTimeRange, lastModifiedDateTimeRange, monthlyIncomeRange); 
    }

    private SearchLeadsParameters buildSearchLeadsParameters(final SearchJobInformationsLeadRequest searchLeadsRequest) {

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

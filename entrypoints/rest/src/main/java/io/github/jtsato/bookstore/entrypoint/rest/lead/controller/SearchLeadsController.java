package io.github.jtsato.bookstore.entrypoint.rest.lead.controller;

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

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.lead.usecase.SearchLeadsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.lead.api.SearchLeadsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request.SearchLeadsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.SearchLeadsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.lead.mapper.SearchLeadsPresenter;
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
@RequestMapping("/leads")
public class SearchLeadsController implements SearchLeadsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchLeadsController.class);

    private final SearchLeadsUseCase searchLeadsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchLeadsWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchLeadsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchLeadsController with {}", jsonRequest);

        final SearchLeadsParameters parameters = buildSearchLeadsParameters(request);
        final Page<Lead> leads = searchLeadsUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchLeadsPresenter.of(leads);
    }

    private SearchLeadsParameters buildSearchLeadsParameters(final SearchLeadsRequest searchLeadsRequest) {

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

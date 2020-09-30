package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.FindJobInformationsByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.api.FindJobInformationsByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request.FindJobInformationsByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.FindJobInformationsByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper.FindJobInformationsByIdsPresenter;
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
public class FindJobInformationsByIdsController implements FindJobInformationsByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindJobInformationsByIdsController.class);

    private final FindJobInformationsByIdsUseCase findJobInformationsByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindJobInformationsByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindJobInformationsByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindJobInformationsByIdsController with {}", jsonRequest);

        final Page<JobInformation> jobInformations = findJobInformationsByIdsUseCase.execute(request.getIds());

        return FindJobInformationsByIdsPresenter.of(jobInformations);
    }
}


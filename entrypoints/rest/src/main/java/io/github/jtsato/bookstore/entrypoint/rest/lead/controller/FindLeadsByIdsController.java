package io.github.jtsato.bookstore.entrypoint.rest.lead.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.FindLeadsByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.lead.api.FindLeadsByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request.FindLeadsByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.FindLeadsByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.lead.mapper.FindLeadsByIdsPresenter;
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
public class FindLeadsByIdsController implements FindLeadsByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindLeadsByIdsController.class);

    private final FindLeadsByIdsUseCase findLeadsByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindLeadsByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindLeadsByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindLeadsByIdsController with {}", jsonRequest);

        final Page<Lead> leads = findLeadsByIdsUseCase.execute(request.getIds());

        return FindLeadsByIdsPresenter.of(leads);
    }
}


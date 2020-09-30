package io.github.jtsato.bookstore.entrypoint.rest.lead.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.GetLeadByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.lead.api.GetLeadByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.GetLeadByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.lead.mapper.GetLeadByIdPresenter;
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
public class GetLeadByIdController implements GetLeadByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetLeadByIdController.class);

    private final GetLeadByIdUseCase getLeadByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetLeadByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetLeadByIdController with {}", id);

        final Lead lead = getLeadByIdUseCase.execute(id);
        return GetLeadByIdPresenter.of(lead);
    }
}

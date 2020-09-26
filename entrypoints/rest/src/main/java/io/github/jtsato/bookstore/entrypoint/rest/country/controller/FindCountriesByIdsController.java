package io.github.jtsato.bookstore.entrypoint.rest.country.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.FindCountriesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.country.api.FindCountriesByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.request.FindCountriesByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.FindCountriesByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.mapper.FindCountriesByIdsPresenter;
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
@RequestMapping("/countries")
public class FindCountriesByIdsController implements FindCountriesByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindCountriesByIdsController.class);

    private final FindCountriesByIdsUseCase findCountriesByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindCountriesByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindCountriesByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindCountriesByIdsController with {}", jsonRequest);

        final Page<Country> countries = findCountriesByIdsUseCase.execute(request.getIds());

        return FindCountriesByIdsPresenter.of(countries);
    }
}


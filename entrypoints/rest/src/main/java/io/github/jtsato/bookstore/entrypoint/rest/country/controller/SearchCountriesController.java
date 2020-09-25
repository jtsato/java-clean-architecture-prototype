package io.github.jtsato.bookstore.entrypoint.rest.country.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
import io.github.jtsato.bookstore.core.country.usecase.SearchCountriesUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.country.api.SearchCountriesApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.request.SearchCountriesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.SearchCountriesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.mapper.SearchCountriesPresenter;
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
public class SearchCountriesController implements SearchCountriesApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchCountriesController.class);

    private final SearchCountriesUseCase searchCountriesUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchCountriesWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchCountriesRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchCountriesController with {}", jsonRequest);

        final SearchCountriesParameters parameters = buildSearchCountriesParameters(request);
        final Page<Country> countries = searchCountriesUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchCountriesPresenter.of(countries);
    }

    private SearchCountriesParameters buildSearchCountriesParameters(final SearchCountriesRequest searchCountriesRequest) {

        final Long id = searchCountriesRequest.getId();
        final String name = searchCountriesRequest.getName();
        return new SearchCountriesParameters(id, name); 
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.country.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.GetCountryByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.country.api.GetCountryByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.GetCountryByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.mapper.GetCountryByIdPresenter;
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
public class GetCountryByIdController implements GetCountryByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetCountryByIdController.class);

    private final GetCountryByIdUseCase getCountryByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetCountryByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetCountryByIdController with {}", id);

        final Country country = getCountryByIdUseCase.execute(id);
        return GetCountryByIdPresenter.of(country);
    }
}

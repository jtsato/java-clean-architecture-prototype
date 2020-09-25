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
import io.github.jtsato.bookstore.core.country.usecase.RegisterCountryUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.RegisterCountryParameters;
import io.github.jtsato.bookstore.entrypoint.rest.country.api.RegisterCountryApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.request.RegisterCountryRequest;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.RegisterCountryResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.mapper.RegisterCountryPresenter;
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
public class RegisterCountryController implements RegisterCountryApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterCountryController.class);

    private final RegisterCountryUseCase registerCountryUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterCountryResponse execute(@RequestBody @DefaultValue final RegisterCountryRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterCountryController with {}", jsonRequest);

        final RegisterCountryParameters parameters = new RegisterCountryParameters(request.getName());

        final Country country = registerCountryUseCase.execute(parameters);
        return RegisterCountryPresenter.of(country);
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.country.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.usecase.UpdateCountryByIdUseCase;
import io.github.jtsato.bookstore.core.country.usecase.parameter.UpdateCountryByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.country.api.UpdateCountryByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.request.UpdateCountryByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.UpdateCountryByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.mapper.UpdateCountryByIdPresenter;
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
public class UpdateCountryByIdController implements UpdateCountryByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateCountryByIdController.class);

    private final UpdateCountryByIdUseCase updateCountryByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateCountryByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateCountryByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateCountryByIdController with {}", jsonRequest);

        final UpdateCountryByIdParameters parameters = new UpdateCountryByIdParameters(id,
                                                                                       request.getName());
        final Country country = updateCountryByIdUseCase.execute(parameters);
        return UpdateCountryByIdPresenter.of(country);
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.address.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.RegisterAddressUseCase;
import io.github.jtsato.bookstore.core.address.usecase.parameter.RegisterAddressParameters;
import io.github.jtsato.bookstore.entrypoint.rest.address.api.RegisterAddressApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.request.RegisterAddressRequest;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.RegisterAddressResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.mapper.RegisterAddressPresenter;
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
@RequestMapping("/addresses")
public class RegisterAddressController implements RegisterAddressApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterAddressController.class);

    private final RegisterAddressUseCase registerAddressUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterAddressResponse execute(@RequestBody @DefaultValue final RegisterAddressRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterAddressController with {}", jsonRequest);

        final RegisterAddressParameters parameters = new RegisterAddressParameters(request.getLeadId(),
                                                                                   request.getZipCode(),
                                                                                   request.getCity(),
                                                                                   request.getState(),
                                                                                   request.getCountry(),
                                                                                   request.getDescription(),
                                                                                   request.getComplement(),
                                                                                   request.getNumber(),
                                                                                   request.getType());

        final Address address = registerAddressUseCase.execute(parameters);
        return RegisterAddressPresenter.of(address);
    }
}

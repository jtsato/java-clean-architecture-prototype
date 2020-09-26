package io.github.jtsato.bookstore.entrypoint.rest.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.RegisterCustomerUseCase;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.RegisterCustomerParameters;
import io.github.jtsato.bookstore.entrypoint.rest.customer.api.RegisterCustomerApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request.RegisterCustomerRequest;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.RegisterCustomerResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.mapper.RegisterCustomerPresenter;
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
@RequestMapping("/customers")
public class RegisterCustomerController implements RegisterCustomerApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterCustomerController.class);

    private final RegisterCustomerUseCase registerCustomerUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterCustomerResponse execute(@RequestBody @DefaultValue final RegisterCustomerRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterCustomerController with {}", jsonRequest);

        final RegisterCustomerParameters parameters = new RegisterCustomerParameters(request.getName(),
                                                                                     request.getAddress());

        final Customer customer = registerCustomerUseCase.execute(parameters);
        return RegisterCustomerPresenter.of(customer);
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.customer.controller;

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

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.UpdateCustomerByIdUseCase;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.UpdateCustomerByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.customer.api.UpdateCustomerByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request.UpdateCustomerByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.UpdateCustomerByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.mapper.UpdateCustomerByIdPresenter;
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
public class UpdateCustomerByIdController implements UpdateCustomerByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateCustomerByIdController.class);

    private final UpdateCustomerByIdUseCase updateCustomerByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateCustomerByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateCustomerByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateCustomerByIdController with {}", jsonRequest);

        final UpdateCustomerByIdParameters parameters = new UpdateCustomerByIdParameters(id,
                                                                                         request.getName(),
                                                                                         request.getAddress());
        final Customer customer = updateCustomerByIdUseCase.execute(parameters);
        return UpdateCustomerByIdPresenter.of(customer);
    }
}

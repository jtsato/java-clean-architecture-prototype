package io.github.jtsato.bookstore.entrypoint.rest.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.GetCustomerByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.customer.api.GetCustomerByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.GetCustomerByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.mapper.GetCustomerByIdPresenter;
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
public class GetCustomerByIdController implements GetCustomerByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetCustomerByIdController.class);

    private final GetCustomerByIdUseCase getCustomerByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetCustomerByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetCustomerByIdController with {}", id);

        final Customer customer = getCustomerByIdUseCase.execute(id);
        return GetCustomerByIdPresenter.of(customer);
    }
}

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
import io.github.jtsato.bookstore.core.customer.usecase.FindCustomersByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.customer.api.FindCustomersByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request.FindCustomersByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.FindCustomersByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.mapper.FindCustomersByIdsPresenter;
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
public class FindCustomersByIdsController implements FindCustomersByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindCustomersByIdsController.class);

    private final FindCustomersByIdsUseCase findCustomersByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindCustomersByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindCustomersByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindCustomersByIdsController with {}", jsonRequest);

        final Page<Customer> customers = findCustomersByIdsUseCase.execute(request.getIds());

        return FindCustomersByIdsPresenter.of(customers);
    }
}


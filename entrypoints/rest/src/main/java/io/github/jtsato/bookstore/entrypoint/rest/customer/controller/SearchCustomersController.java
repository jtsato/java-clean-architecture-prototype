package io.github.jtsato.bookstore.entrypoint.rest.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.core.customer.usecase.parameter.SearchCustomersParameters;
import io.github.jtsato.bookstore.core.customer.usecase.SearchCustomersUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.customer.api.SearchCustomersApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request.SearchCustomersRequest;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.SearchCustomersWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.mapper.SearchCustomersPresenter;
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
public class SearchCustomersController implements SearchCustomersApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchCustomersController.class);

    private final SearchCustomersUseCase searchCustomersUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchCustomersWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchCustomersRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchCustomersController with {}", jsonRequest);

        final SearchCustomersParameters parameters = buildSearchCustomersParameters(request);
        final Page<Customer> customers = searchCustomersUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchCustomersPresenter.of(customers);
    }

    private SearchCustomersParameters buildSearchCustomersParameters(final SearchCustomersRequest searchCustomersRequest) {

        final Long id = searchCustomersRequest.getId();
        final String name = searchCustomersRequest.getName();
        final String address = searchCustomersRequest.getAddress();
        return new SearchCustomersParameters(id, name, address); 
    }
}

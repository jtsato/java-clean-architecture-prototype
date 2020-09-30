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
import io.github.jtsato.bookstore.core.address.usecase.FindAddressesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.address.api.FindAddressesByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.request.FindAddressesByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.FindAddressesByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.mapper.FindAddressesByIdsPresenter;
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
public class FindAddressesByIdsController implements FindAddressesByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindAddressesByIdsController.class);

    private final FindAddressesByIdsUseCase findAddressesByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindAddressesByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindAddressesByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindAddressesByIdsController with {}", jsonRequest);

        final Page<Address> addresses = findAddressesByIdsUseCase.execute(request.getIds());

        return FindAddressesByIdsPresenter.of(addresses);
    }
}


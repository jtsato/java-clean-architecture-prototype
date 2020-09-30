package io.github.jtsato.bookstore.entrypoint.rest.address.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.GetAddressByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.address.api.GetAddressByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.GetAddressByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.mapper.GetAddressByIdPresenter;
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
public class GetAddressByIdController implements GetAddressByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetAddressByIdController.class);

    private final GetAddressByIdUseCase getAddressByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetAddressByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetAddressByIdController with {}", id);

        final Address address = getAddressByIdUseCase.execute(id);
        return GetAddressByIdPresenter.of(address);
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.balance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.FindBalancesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.balance.api.FindBalancesByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request.FindBalancesByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.FindBalancesByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.balance.mapper.FindBalancesByIdsPresenter;
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
@RequestMapping("/balances")
public class FindBalancesByIdsController implements FindBalancesByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindBalancesByIdsController.class);

    private final FindBalancesByIdsUseCase findBalancesByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindBalancesByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindBalancesByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindBalancesByIdsController with {}", jsonRequest);

        final Page<Balance> balances = findBalancesByIdsUseCase.execute(request.getIds());

        return FindBalancesByIdsPresenter.of(balances);
    }
}


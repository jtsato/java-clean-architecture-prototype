package io.github.jtsato.bookstore.entrypoint.rest.balance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.GetBalanceByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.balance.api.GetBalanceByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.GetBalanceByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.balance.mapper.GetBalanceByIdPresenter;
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
public class GetBalanceByIdController implements GetBalanceByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetBalanceByIdController.class);

    private final GetBalanceByIdUseCase getBalanceByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetBalanceByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetBalanceByIdController with {}", id);

        final Balance balance = getBalanceByIdUseCase.execute(id);
        return GetBalanceByIdPresenter.of(balance);
    }
}

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
import io.github.jtsato.bookstore.core.balance.usecase.RegisterBalanceUseCase;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.RegisterBalanceParameters;
import io.github.jtsato.bookstore.entrypoint.rest.balance.api.RegisterBalanceApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request.RegisterBalanceRequest;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.RegisterBalanceResponse;
import io.github.jtsato.bookstore.entrypoint.rest.balance.mapper.RegisterBalancePresenter;
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
public class RegisterBalanceController implements RegisterBalanceApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterBalanceController.class);

    private final RegisterBalanceUseCase registerBalanceUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterBalanceResponse execute(@RequestBody @DefaultValue final RegisterBalanceRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterBalanceController with {}", jsonRequest);

        final RegisterBalanceParameters parameters = new RegisterBalanceParameters(request.getCustomerNumber(),
                                                                                   request.getCurrency1(),
                                                                                   request.getResourceOrigin1(),
                                                                                   request.getCurrency(),
                                                                                   request.getResourceOrigin(),
                                                                                   request.getDebitBalance(),
                                                                                   request.getContractedPrincipal(),
                                                                                   request.getContractedInterest(),
                                                                                   request.getContractedTotal(),
                                                                                   request.getPaidPrincipal(),
                                                                                   request.getPaidInterest(),
                                                                                   request.getPaidTotal());

        final Balance balance = registerBalanceUseCase.execute(parameters);
        return RegisterBalancePresenter.of(balance);
    }
}

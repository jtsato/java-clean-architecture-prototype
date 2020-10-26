package io.github.jtsato.bookstore.entrypoint.rest.balance.controller;

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

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.UpdateBalanceByIdUseCase;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.UpdateBalanceByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.balance.api.UpdateBalanceByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request.UpdateBalanceByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.UpdateBalanceByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.balance.mapper.UpdateBalanceByIdPresenter;
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
public class UpdateBalanceByIdController implements UpdateBalanceByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateBalanceByIdController.class);

    private final UpdateBalanceByIdUseCase updateBalanceByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateBalanceByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateBalanceByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateBalanceByIdController with {}", jsonRequest);

        final UpdateBalanceByIdParameters parameters = new UpdateBalanceByIdParameters(id,
                                                                                       request.getCustomerNumber(),
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
        final Balance balance = updateBalanceByIdUseCase.execute(parameters);
        return UpdateBalanceByIdPresenter.of(balance);
    }
}

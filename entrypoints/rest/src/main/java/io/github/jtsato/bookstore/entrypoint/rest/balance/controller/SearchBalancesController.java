package io.github.jtsato.bookstore.entrypoint.rest.balance.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.SearchBalancesParameters;
import io.github.jtsato.bookstore.core.balance.usecase.SearchBalancesUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.balance.api.SearchBalancesApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request.SearchBalancesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.SearchBalancesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.balance.mapper.SearchBalancesPresenter;
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
public class SearchBalancesController implements SearchBalancesApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchBalancesController.class);

    private final SearchBalancesUseCase searchBalancesUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchBalancesWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchBalancesRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchBalancesController with {}", jsonRequest);

        final SearchBalancesParameters parameters = buildSearchBalancesParameters(request);
        final Page<Balance> balances = searchBalancesUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchBalancesPresenter.of(balances);
    }

    private SearchBalancesParameters buildSearchBalancesParameters(final SearchBalancesRequest searchBalancesRequest) {

        final Long id = searchBalancesRequest.getId();
        final String customerNumber = searchBalancesRequest.getCustomerNumber();
        final String currency1 = searchBalancesRequest.getCurrency1();
        final String resourceOrigin1 = searchBalancesRequest.getResourceOrigin1();
        final String currency = searchBalancesRequest.getCurrency();
        final String resourceOrigin = searchBalancesRequest.getResourceOrigin();
        final ImmutablePair<BigDecimal, BigDecimal> debitBalanceRange = new ImmutablePair<>(searchBalancesRequest.getStartDebitBalance(), searchBalancesRequest.getEndDebitBalance());
        final ImmutablePair<BigDecimal, BigDecimal> contractedPrincipalRange = new ImmutablePair<>(searchBalancesRequest.getStartContractedPrincipal(), searchBalancesRequest.getEndContractedPrincipal());
        final ImmutablePair<BigDecimal, BigDecimal> contractedInterestRange = new ImmutablePair<>(searchBalancesRequest.getStartContractedInterest(), searchBalancesRequest.getEndContractedInterest());
        final ImmutablePair<BigDecimal, BigDecimal> contractedTotalRange = new ImmutablePair<>(searchBalancesRequest.getStartContractedTotal(), searchBalancesRequest.getEndContractedTotal());
        final ImmutablePair<BigDecimal, BigDecimal> paidPrincipalRange = new ImmutablePair<>(searchBalancesRequest.getStartPaidPrincipal(), searchBalancesRequest.getEndPaidPrincipal());
        final ImmutablePair<BigDecimal, BigDecimal> paidInterestRange = new ImmutablePair<>(searchBalancesRequest.getStartPaidInterest(), searchBalancesRequest.getEndPaidInterest());
        final ImmutablePair<BigDecimal, BigDecimal> paidTotalRange = new ImmutablePair<>(searchBalancesRequest.getStartPaidTotal(), searchBalancesRequest.getEndPaidTotal());
        return new SearchBalancesParameters(id, customerNumber, currency1, resourceOrigin1, currency, resourceOrigin, debitBalanceRange, contractedPrincipalRange, contractedInterestRange, contractedTotalRange, paidPrincipalRange, paidInterestRange, paidTotalRange); 
    }
}

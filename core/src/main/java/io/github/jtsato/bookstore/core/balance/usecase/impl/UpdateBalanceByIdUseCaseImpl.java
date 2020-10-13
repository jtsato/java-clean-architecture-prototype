package io.github.jtsato.bookstore.core.balance.usecase.impl;

import java.math.BigDecimal;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.balance.domain.Currency;
import io.github.jtsato.bookstore.core.balance.domain.ResourceOrigin;
import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.UpdateBalanceByIdGateway;
import io.github.jtsato.bookstore.core.balance.usecase.UpdateBalanceByIdUseCase;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.UpdateBalanceByIdParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */

/**
 * @author Jorge Takeshi Sato
 */

@Named
@RequiredArgsConstructor
public class UpdateBalanceByIdUseCaseImpl implements UpdateBalanceByIdUseCase {

    private final UpdateBalanceByIdGateway updateBalanceByIdGateway;

    @Override
    public Balance execute(final UpdateBalanceByIdParameters parameters) {

        final Long id = parameters.getId();
        final String customerNumber = StringUtils.stripToEmpty(parameters.getCustomerNumber());
        final Currency currency = EnumeratorUtils.valueOf(parameters.getCurrency(), Currency.class);
        final ResourceOrigin resourceOrigin = EnumeratorUtils.valueOf(parameters.getResourceOrigin(), ResourceOrigin.class);
        final BigDecimal debitBalance = parameters.getDebitBalance();
        final BigDecimal contractedPrincipal = parameters.getContractedPrincipal();
        final BigDecimal contractedInterest = parameters.getContractedInterest();
        final BigDecimal contractedTotal = parameters.getContractedTotal();
        final BigDecimal paidPrincipal = parameters.getPaidPrincipal();
        final BigDecimal paidInterest = parameters.getPaidInterest();
        final BigDecimal paidTotal = parameters.getPaidTotal();

        final Balance balance = new Balance(id ,
                                            customerNumber,
                                            currency,
                                            resourceOrigin,
                                            debitBalance,
                                            contractedPrincipal,
                                            contractedInterest,
                                            contractedTotal,
                                            paidPrincipal,
                                            paidInterest,
                                            paidTotal);

        final Optional<Balance> optional = updateBalanceByIdGateway.execute(balance);
        return optional.orElseThrow(() -> new NotFoundException("validation.balance.id.notfound", String.valueOf(parameters.getId())));
    }
}

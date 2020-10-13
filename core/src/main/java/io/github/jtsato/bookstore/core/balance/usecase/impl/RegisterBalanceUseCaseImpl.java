package io.github.jtsato.bookstore.core.balance.usecase.impl;

import java.math.BigDecimal;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.balance.domain.Currency;
import io.github.jtsato.bookstore.core.balance.domain.ResourceOrigin;
import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.RegisterBalanceGateway;
import io.github.jtsato.bookstore.core.balance.usecase.RegisterBalanceUseCase;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.RegisterBalanceParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
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
public class RegisterBalanceUseCaseImpl implements RegisterBalanceUseCase {

    private final RegisterBalanceGateway registerBalanceGateway;

    @Override
    public Balance execute(final RegisterBalanceParameters parameters) {

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

        final Balance balance = new Balance(null,
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

        return registerBalanceGateway.execute(balance);
    }
}

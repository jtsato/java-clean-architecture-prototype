package io.github.jtsato.bookstore.entrypoint.rest.balance.mapper;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.UpdateBalanceByIdResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateBalanceByIdPresenter {


    public static UpdateBalanceByIdResponse of(final Balance balance) {
        return new UpdateBalanceByIdResponse(balance.getId(),
                                             balance.getCustomerNumber(),
                                             balance.getCurrency().name(),
                                             balance.getResourceOrigin().name(),
                                             balance.getDebitBalance(),
                                             balance.getContractedPrincipal(),
                                             balance.getContractedInterest(),
                                             balance.getContractedTotal(),
                                             balance.getPaidPrincipal(),
                                             balance.getPaidInterest(),
                                             balance.getPaidTotal());
    }
}

package io.github.jtsato.bookstore.entrypoint.rest.balance.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.FindBalancesByIdsResponse;

import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.FindBalancesByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindBalancesByIdsPresenter {

    public static FindBalancesByIdsWrapperResponse of(final Page<Balance> page) {
        final List<Balance> balances = page.getContent();
        final List<FindBalancesByIdsResponse> content = new ArrayList<>(balances.size());
        balances.forEach(element -> content.add(of(element)));
        return new FindBalancesByIdsWrapperResponse(content, page.getPageable());
    }


    public static FindBalancesByIdsResponse of(final Balance balance) {
        return new FindBalancesByIdsResponse(balance.getId(),
                                             balance.getCustomerNumber(),
                                             balance.getCurrency1(),
                                             balance.getResourceOrigin1(),
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

package io.github.jtsato.bookstore.entrypoint.rest.balance.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.balance.domain.Balance;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.SearchBalancesResponse;

import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.SearchBalancesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.SessionResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchBalancesPresenter {

    public static SearchBalancesWrapperResponse of(final Page<Balance> page) {
        final List<Balance> balances = page.getContent();
        final List<SearchBalancesResponse> content = new ArrayList<>(balances.size());
        balances.forEach(element -> content.add(of(element)));
        return new SearchBalancesWrapperResponse(content, page.getPageable());
    }


    public static SearchBalancesResponse of(final Balance balance) {
        final SessionResponse contracted = new SessionResponse(balance.getContractedPrincipal(), balance.getContractedInterest(), balance.getContractedTotal());
        final SessionResponse paid = new SessionResponse(balance.getPaidPrincipal(), balance.getPaidInterest(), balance.getPaidTotal());
        return new SearchBalancesResponse(balance.getId(),
                                          balance.getCustomerNumber(),
                                          balance.getCurrency().name(),
                                          balance.getResourceOrigin().name(),
                                          balance.getDebitBalance(),
                                          contracted,
                                          paid);
    }
}

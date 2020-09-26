package io.github.jtsato.bookstore.entrypoint.rest.customer.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.SearchCustomersResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.SearchCustomersWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchCustomersPresenter {

    public static SearchCustomersWrapperResponse of(final Page<Customer> page) {
        final List<Customer> customers = page.getContent();
        final List<SearchCustomersResponse> content = new ArrayList<>(customers.size());
        customers.forEach(element -> content.add(of(element)));
        return new SearchCustomersWrapperResponse(content, page.getPageable());
    }

    public static SearchCustomersResponse of(final Customer customer) {
        return new SearchCustomersResponse(customer.getId(),
                                           customer.getName(),
                                           customer.getAddress());
    }
}

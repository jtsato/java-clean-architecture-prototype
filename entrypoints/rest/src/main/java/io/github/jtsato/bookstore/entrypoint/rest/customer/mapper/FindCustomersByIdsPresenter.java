package io.github.jtsato.bookstore.entrypoint.rest.customer.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.FindCustomersByIdsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.FindCustomersByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindCustomersByIdsPresenter {

    public static FindCustomersByIdsWrapperResponse of(final Page<Customer> page) {
        final List<Customer> customers = page.getContent();
        final List<FindCustomersByIdsResponse> content = new ArrayList<>(customers.size());
        customers.forEach(element -> content.add(of(element)));
        return new FindCustomersByIdsWrapperResponse(content, page.getPageable());
    }

    public static FindCustomersByIdsResponse of(final Customer customer) {
        return new FindCustomersByIdsResponse(customer.getId(),
                                              customer.getName(),
                                              customer.getAddress());
    }
}

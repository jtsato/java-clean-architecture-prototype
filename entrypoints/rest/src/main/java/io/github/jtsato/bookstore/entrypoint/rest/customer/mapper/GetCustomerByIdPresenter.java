package io.github.jtsato.bookstore.entrypoint.rest.customer.mapper;

import io.github.jtsato.bookstore.core.customer.domain.Customer;
import io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response.GetCustomerByIdResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetCustomerByIdPresenter {

    public static GetCustomerByIdResponse of(final Customer customer) {
        return new GetCustomerByIdResponse(customer.getId(),
                                           customer.getName(),
                                           customer.getAddress());
    }
}

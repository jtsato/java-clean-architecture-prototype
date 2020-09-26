package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class FindCustomersByIdsResponse implements Serializable {

    private static final long serialVersionUID = 852074289351182043L;

    private final Long id;
    private final String name;
    private final String address;
}

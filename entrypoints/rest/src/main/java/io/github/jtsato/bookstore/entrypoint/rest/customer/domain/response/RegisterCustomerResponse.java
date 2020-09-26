package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class RegisterCustomerResponse implements Serializable {

    private static final long serialVersionUID = -4374782725446087506L;

    private final Long id;
    private final String name;
    private final String address;
}

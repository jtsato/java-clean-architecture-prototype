package io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class SearchBalancesResponse implements Serializable {

    private static final long serialVersionUID = -1205399252670397443L;

    private final Long id;
    private final String customerNumber;
    private final String currency;
    private final String resourceOrigin;
    private final BigDecimal debitBalance;
    private final SessionResponse contracted;
    private final SessionResponse paid;
}

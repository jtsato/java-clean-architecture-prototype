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

    private static final long serialVersionUID = 3178587774062907250L;

    private final Long id;
    private final String customerNumber;
    private final String currency;
    private final String resourceOrigin;
    private final BigDecimal debitBalance;
    private final BigDecimal contractedPrincipal;
    private final BigDecimal contractedInterest;
    private final BigDecimal contractedTotal;
    private final BigDecimal paidPrincipal;
    private final BigDecimal paidInterest;
    private final BigDecimal paidTotal;
}

package io.github.jtsato.bookstore.core.balance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Balance implements Serializable {

    private static final long serialVersionUID = -9183050201790068351L;

    private final Long id;
    private final String customerNumber;
    private final String currency1;
    private final String resourceOrigin1;
    private final Currency currency;
    private final ResourceOrigin resourceOrigin;
    private final BigDecimal debitBalance;
    private final BigDecimal contractedPrincipal;
    private final BigDecimal contractedInterest;
    private final BigDecimal contractedTotal;
    private final BigDecimal paidPrincipal;
    private final BigDecimal paidInterest;
    private final BigDecimal paidTotal;
}

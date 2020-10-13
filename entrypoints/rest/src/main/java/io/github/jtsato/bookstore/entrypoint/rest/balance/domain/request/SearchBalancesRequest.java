package io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class SearchBalancesRequest implements Serializable {

    private static final long serialVersionUID = 4364375431832421966L;

    private Long id;
    private String customerNumber;
    private String currency;
    private String resourceOrigin;
    private BigDecimal startDebitBalance;
    private BigDecimal endDebitBalance;
    private BigDecimal startContractedPrincipal;
    private BigDecimal endContractedPrincipal;
    private BigDecimal startContractedInterest;
    private BigDecimal endContractedInterest;
    private BigDecimal startContractedTotal;
    private BigDecimal endContractedTotal;
    private BigDecimal startPaidPrincipal;
    private BigDecimal endPaidPrincipal;
    private BigDecimal startPaidInterest;
    private BigDecimal endPaidInterest;
    private BigDecimal startPaidTotal;
    private BigDecimal endPaidTotal;
}

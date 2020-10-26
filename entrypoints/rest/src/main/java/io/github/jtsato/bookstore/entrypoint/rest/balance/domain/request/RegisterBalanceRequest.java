package io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterBalanceRequest implements Serializable {

    private static final long serialVersionUID = 4282940160880954353L;

    private String customerNumber;
    private String currency1;
    private String resourceOrigin1;
    private String currency;
    private String resourceOrigin;
    private BigDecimal debitBalance;
    private BigDecimal contractedPrincipal;
    private BigDecimal contractedInterest;
    private BigDecimal contractedTotal;
    private BigDecimal paidPrincipal;
    private BigDecimal paidInterest;
    private BigDecimal paidTotal;
}

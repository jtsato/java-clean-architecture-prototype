package io.github.jtsato.bookstore.core.balance.usecase.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.common.validation.SelfValidating;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class SearchBalancesParameters extends SelfValidating<SearchBalancesParameters> implements Serializable {

    private static final long serialVersionUID = 1902875975959986394L;

    private Long id;

    private String customerNumber;

    private String currency1;

    private String resourceOrigin1;

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

    public SearchBalancesParameters(final Long id,
                                    final String customerNumber,
                                    final String currency1,
                                    final String resourceOrigin1,
                                    final String currency,
                                    final String resourceOrigin,
                                    final ImmutablePair<BigDecimal, BigDecimal> debitBalanceRange,
                                    final ImmutablePair<BigDecimal, BigDecimal> contractedPrincipalRange,
                                    final ImmutablePair<BigDecimal, BigDecimal> contractedInterestRange,
                                    final ImmutablePair<BigDecimal, BigDecimal> contractedTotalRange,
                                    final ImmutablePair<BigDecimal, BigDecimal> paidPrincipalRange,
                                    final ImmutablePair<BigDecimal, BigDecimal> paidInterestRange,
                                    final ImmutablePair<BigDecimal, BigDecimal> paidTotalRange) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.currency1 = currency1;
        this.resourceOrigin1 = resourceOrigin1;
        this.currency = currency;
        this.resourceOrigin = resourceOrigin;
        this.startDebitBalance = debitBalanceRange.getLeft();
        this.endDebitBalance = debitBalanceRange.getRight();
        this.startContractedPrincipal = contractedPrincipalRange.getLeft();
        this.endContractedPrincipal = contractedPrincipalRange.getRight();
        this.startContractedInterest = contractedInterestRange.getLeft();
        this.endContractedInterest = contractedInterestRange.getRight();
        this.startContractedTotal = contractedTotalRange.getLeft();
        this.endContractedTotal = contractedTotalRange.getRight();
        this.startPaidPrincipal = paidPrincipalRange.getLeft();
        this.endPaidPrincipal = paidPrincipalRange.getRight();
        this.startPaidInterest = paidInterestRange.getLeft();
        this.endPaidInterest = paidInterestRange.getRight();
        this.startPaidTotal = paidTotalRange.getLeft();
        this.endPaidTotal = paidTotalRange.getRight();
        this.validateSelf();
    }
}
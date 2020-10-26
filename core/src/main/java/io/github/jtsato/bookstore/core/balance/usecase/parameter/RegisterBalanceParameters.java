package io.github.jtsato.bookstore.core.balance.usecase.parameter;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class RegisterBalanceParameters extends SelfValidating<RegisterBalanceParameters> implements Serializable {

    private static final long serialVersionUID = 1821929395739314275L;

    @NotBlank(message = "validation.balance.customer.number.blank")
    private final String customerNumber;

    @NotBlank(message = "validation.balance.currency.1.blank")
    private final String currency1;

    @NotBlank(message = "validation.balance.resource.origin.1.blank")
    private final String resourceOrigin1;

    @NotBlank(message = "validation.balance.currency.blank")
    private final String currency;

    @NotBlank(message = "validation.balance.resource.origin.blank")
    private final String resourceOrigin;

    @NotNull(message = "validation.balance.debit.balance.null")
    private final BigDecimal debitBalance; 

    @NotNull(message = "validation.balance.contracted.principal.null")
    private final BigDecimal contractedPrincipal; 

    @NotNull(message = "validation.balance.contracted.interest.null")
    private final BigDecimal contractedInterest; 

    @NotNull(message = "validation.balance.contracted.total.null")
    private final BigDecimal contractedTotal; 

    @NotNull(message = "validation.balance.paid.principal.null")
    private final BigDecimal paidPrincipal; 

    @NotNull(message = "validation.balance.paid.interest.null")
    private final BigDecimal paidInterest; 

    @NotNull(message = "validation.balance.paid.total.null")
    private final BigDecimal paidTotal; 

    public RegisterBalanceParameters(final String customerNumber,
                                     final String currency1,
                                     final String resourceOrigin1,
                                     final String currency,
                                     final String resourceOrigin,
                                     final BigDecimal debitBalance,
                                     final BigDecimal contractedPrincipal,
                                     final BigDecimal contractedInterest,
                                     final BigDecimal contractedTotal,
                                     final BigDecimal paidPrincipal,
                                     final BigDecimal paidInterest,
                                     final BigDecimal paidTotal) {
        this.customerNumber = customerNumber;
        this.currency1 = currency1;
        this.resourceOrigin1 = resourceOrigin1;
        this.currency = currency;
        this.resourceOrigin = resourceOrigin;
        this.debitBalance = debitBalance;
        this.contractedPrincipal = contractedPrincipal;
        this.contractedInterest = contractedInterest;
        this.contractedTotal = contractedTotal;
        this.paidPrincipal = paidPrincipal;
        this.paidInterest = paidInterest;
        this.paidTotal = paidTotal;
        this.validateSelf();
    }
}

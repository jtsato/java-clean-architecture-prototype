package io.github.jtsato.bookstore.dataprovider.balance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BALANCES",
       indexes = {
            @Index(columnList = "CURRENCY", name = "IDX_BALANCES_CURRENCY"),
            @Index(columnList = "RESOURCE_ORIGIN", name = "IDX_BALANCES_RESOURCE_ORIGIN"),
            @Index(columnList = "CUSTOMER_NUMBER", name = "IDX_BALANCES_CUSTOMER_NUMBER"),
       }
)
public class BalanceEntity implements Serializable {

    private static final long serialVersionUID = -7571419576584287463L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BALANCE_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "RESOURCE_ORIGIN", nullable = false)
    private String resourceOrigin;

    @Column(name = "CUSTOMER_NUMBER", nullable = false)
    private String customerNumber;

    @Column(name = "DEBIT_BALANCE", nullable = false)
    private BigDecimal debitBalance;

    @Column(name = "CONTRACTED_PRINCIPAL", nullable = false)
    private BigDecimal contractedPrincipal;

    @Column(name = "CONTRACTED_INTEREST", nullable = false)
    private BigDecimal contractedInterest;

    @Column(name = "CONTRACTED_TOTAL", nullable = false)
    private BigDecimal contractedTotal;

    @Column(name = "PAID_PRINCIPAL", nullable = false)
    private BigDecimal paidPrincipal;

    @Column(name = "PAID_INTEREST", nullable = false)
    private BigDecimal paidInterest;

    @Column(name = "PAID_TOTAL", nullable = false)
    private BigDecimal paidTotal;

    @Override
    public int hashCode() {
        final int prime = 23;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BalanceEntity other = (BalanceEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Balance [id=");
        builder.append(id);
        builder.append(", customerNumber=");
        builder.append(customerNumber);
        builder.append(", debitBalance=");
        builder.append(debitBalance);
        builder.append(", contractedPrincipal=");
        builder.append(contractedPrincipal);
        builder.append(", contractedInterest=");
        builder.append(contractedInterest);
        builder.append(", contractedTotal=");
        builder.append(contractedTotal);
        builder.append(", paidPrincipal=");
        builder.append(paidPrincipal);
        builder.append(", paidInterest=");
        builder.append(paidInterest);
        builder.append(", paidTotal=");
        builder.append(paidTotal);
        builder.append("]");
        return builder.toString();
    }
}

package io.github.jtsato.bookstore.dataprovider.jobinformation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
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
@Table(name = "JOB_INFORMATIONS",
       indexes = {
            @Index(columnList = "LEAD_ID", name = "IDX_JOB_INFORMATIONS_LEAD_ID"),
            @Index(columnList = "RECEIPT_TYPE", name = "IDX_JOB_INFORMATIONS_RECEIPT_TYPE"),
            @Index(columnList = "START_DATE", name = "IDX_JOB_INFORMATIONS_START_DATE"),
            @Index(columnList = "CREATED_DATE_TIME", name = "IDX_JOB_INFORMATIONS_CREATED_DATE_TIME"),
            @Index(columnList = "LAST_MODIFIED_DATE_TIME", name = "IDX_JOB_INFORMATIONS_LAST_MODIFIED_DATE_TIME"),
       }
)
public class JobInformationEntity implements Serializable {

    private static final long serialVersionUID = -3757402138185545575L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_INFORMATION_ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "LEAD_ID", foreignKey = @ForeignKey(name = "FK_JOB_INFORMATIONS_LEAD_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeadEntity lead;

    @Column(name = "RECEIPT_TYPE", nullable = false)
    private String receiptType;

    @Column(name = "PROFESSION", nullable = false)
    private String profession;

    @Column(name = "MONTHLY_INCOME", nullable = false)
    private BigDecimal monthlyIncome;

    @Column(name = "REFERENCE_MONTH", nullable = false)
    private String referenceMonth;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "ATTACH", nullable = false)
    private Long attach;

    @Column(name = "CREATED_DATE_TIME")
    private LocalDateTime createdDateTime;

    @Column(name = "LAST_MODIFIED_DATE_TIME")
    private LocalDateTime lastModifiedDateTime;

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
        final JobInformationEntity other = (JobInformationEntity) obj;
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
        builder.append("JobInformation [id=");
        builder.append(id);
        builder.append(", profession=");
        builder.append(profession);
        builder.append(", monthlyIncome=");
        builder.append(monthlyIncome);
        builder.append(", referenceMonth=");
        builder.append(referenceMonth);
        builder.append(", startDate=");
        builder.append(startDate);
        builder.append(", attach=");
        builder.append(attach);
        builder.append(", createdDateTime=");
        builder.append(createdDateTime);
        builder.append(", lastModifiedDateTime=");
        builder.append(lastModifiedDateTime);
        builder.append("]");
        return builder.toString();
    }
}

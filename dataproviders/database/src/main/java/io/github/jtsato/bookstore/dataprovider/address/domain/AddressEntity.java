package io.github.jtsato.bookstore.dataprovider.address.domain;

import java.io.Serializable;
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
@Table(name = "ADDRESSES",
       indexes = {
            @Index(columnList = "LEAD_ID", name = "IDX_ADDRESSES_LEAD_ID"),
            @Index(columnList = "TYPE", name = "IDX_ADDRESSES_TYPE"),
            @Index(columnList = "CREATED_DATE_TIME", name = "IDX_ADDRESSES_CREATED_DATE_TIME"),
            @Index(columnList = "LAST_MODIFIED_DATE_TIME", name = "IDX_ADDRESSES_LAST_MODIFIED_DATE_TIME"),
       }
)
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 3926350255135605537L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "LEAD_ID", foreignKey = @ForeignKey(name = "FK_ADDRESSES_LEAD_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeadEntity lead;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "NUMBER", nullable = false)
    private String number;

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
        final AddressEntity other = (AddressEntity) obj;
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
        builder.append("Address [id=");
        builder.append(id);
        builder.append(", zipCode=");
        builder.append(zipCode);
        builder.append(", city=");
        builder.append(city);
        builder.append(", state=");
        builder.append(state);
        builder.append(", country=");
        builder.append(country);
        builder.append(", description=");
        builder.append(description);
        builder.append(", complement=");
        builder.append(complement);
        builder.append(", number=");
        builder.append(number);
        builder.append(", createdDateTime=");
        builder.append(createdDateTime);
        builder.append(", lastModifiedDateTime=");
        builder.append(lastModifiedDateTime);
        builder.append("]");
        return builder.toString();
    }
}

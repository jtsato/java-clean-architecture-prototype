package io.github.jtsato.bookstore.dataprovider.lead.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name = "LEADS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"CPF"}, name = "UN_LEADS_CPF"),
       },       indexes = {
            @Index(columnList = "GENDER", name = "IDX_LEADS_GENDER"),
            @Index(columnList = "EDUCATION", name = "IDX_LEADS_EDUCATION"),
            @Index(columnList = "MARITAL_STATUS", name = "IDX_LEADS_MARITAL_STATUS"),
            @Index(columnList = "CELLPHONE", name = "IDX_LEADS_CELLPHONE"),
            @Index(columnList = "NAME", name = "IDX_LEADS_NAME"),
            @Index(columnList = "BIRTHDATE", name = "IDX_LEADS_BIRTHDATE"),
            @Index(columnList = "CREATED_DATE_TIME", name = "IDX_LEADS_CREATED_DATE_TIME"),
            @Index(columnList = "LAST_MODIFIED_DATE_TIME", name = "IDX_LEADS_LAST_MODIFIED_DATE_TIME"),
       }
)
public class LeadEntity implements Serializable {

    private static final long serialVersionUID = 2310783261975464216L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEAD_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "EDUCATION", nullable = false)
    private String education;

    @Column(name = "MARITAL_STATUS", nullable = false)
    private String maritalStatus;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "CELLPHONE", nullable = false)
    private String cellphone;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "MOTHER_FULL_NAME", nullable = false)
    private String motherFullName;

    @Column(name = "STABLE_UNION", nullable = false)
    private Boolean stableUnion;

    @Column(name = "CREATED_DATE_TIME")
    private LocalDateTime createdDateTime;

    @Column(name = "LAST_MODIFIED_DATE_TIME")
    private LocalDateTime lastModifiedDateTime;

    @Column(name = "SELFIE_PHOTO", nullable = false)
    private Long selfiePhoto;

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
        final LeadEntity other = (LeadEntity) obj;
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
        builder.append("Lead [id=");
        builder.append(id);
        builder.append(", cpf=");
        builder.append(cpf);
        builder.append(", cellphone=");
        builder.append(cellphone);
        builder.append(", name=");
        builder.append(name);
        builder.append(", birthdate=");
        builder.append(birthdate);
        builder.append(", motherFullName=");
        builder.append(motherFullName);
        builder.append(", stableUnion=");
        builder.append(stableUnion);
        builder.append(", createdDateTime=");
        builder.append(createdDateTime);
        builder.append(", lastModifiedDateTime=");
        builder.append(lastModifiedDateTime);
        builder.append(", selfiePhoto=");
        builder.append(selfiePhoto);
        builder.append("]");
        return builder.toString();
    }
}

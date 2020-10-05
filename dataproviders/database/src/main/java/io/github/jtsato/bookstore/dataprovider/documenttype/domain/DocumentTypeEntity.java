package io.github.jtsato.bookstore.dataprovider.documenttype.domain;

import java.io.Serializable;
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
@Table(name = "DOCUMENT_TYPES",
       indexes = {
            @Index(columnList = "CREATED_DATE_TIME", name = "IDX_DOCUMENT_TYPES_CREATED_DATE_TIME"),
            @Index(columnList = "LAST_MODIFIED_DATE_TIME", name = "IDX_DOCUMENT_TYPES_LAST_MODIFIED_DATE_TIME"),
       }
)
public class DocumentTypeEntity implements Serializable {

    private static final long serialVersionUID = 8120046176797871979L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_TYPE_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

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
        final DocumentTypeEntity other = (DocumentTypeEntity) obj;
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
        builder.append("DocumentType [id=");
        builder.append(id);
        builder.append(", country=");
        builder.append(country);
        builder.append(", description=");
        builder.append(description);
        builder.append(", createdDateTime=");
        builder.append(createdDateTime);
        builder.append(", lastModifiedDateTime=");
        builder.append(lastModifiedDateTime);
        builder.append("]");
        return builder.toString();
    }
}

package io.github.jtsato.bookstore.dataprovider.document.domain;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;
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
@Table(name = "DOCUMENTS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"NUMBER"}, name = "UN_DOCUMENTS_NUMBER"),
       },       indexes = {
            @Index(columnList = "LEAD_ID", name = "IDX_DOCUMENTS_LEAD_ID"),
            @Index(columnList = "TYPE_ID", name = "IDX_DOCUMENTS_TYPE_ID"),
            @Index(columnList = "CREATED_DATE_TIME", name = "IDX_DOCUMENTS_CREATED_DATE_TIME"),
            @Index(columnList = "LAST_MODIFIED_DATE_TIME", name = "IDX_DOCUMENTS_LAST_MODIFIED_DATE_TIME"),
       }
)
public class DocumentEntity implements Serializable {

    private static final long serialVersionUID = -1436017319330037136L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "LEAD_ID", foreignKey = @ForeignKey(name = "FK_DOCUMENTS_LEAD_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeadEntity lead;

    @JoinColumn(name = "TYPE_ID", foreignKey = @ForeignKey(name = "FK_DOCUMENTS_TYPE_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DocumentTypeEntity type;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "ISSUE_DATE", nullable = false)
    private LocalDate issueDate;

    @Column(name = "ISSUER", nullable = false)
    private String issuer;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "FRONT_PHOTO", nullable = false)
    private Long frontPhoto;

    @Column(name = "BACK_PHOTO", nullable = false)
    private Long backPhoto;

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
        final DocumentEntity other = (DocumentEntity) obj;
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
        builder.append("Document [id=");
        builder.append(id);
        builder.append(", number=");
        builder.append(number);
        builder.append(", issueDate=");
        builder.append(issueDate);
        builder.append(", issuer=");
        builder.append(issuer);
        builder.append(", state=");
        builder.append(state);
        builder.append(", frontPhoto=");
        builder.append(frontPhoto);
        builder.append(", backPhoto=");
        builder.append(backPhoto);
        builder.append(", createdDateTime=");
        builder.append(createdDateTime);
        builder.append(", lastModifiedDateTime=");
        builder.append(lastModifiedDateTime);
        builder.append("]");
        return builder.toString();
    }
}

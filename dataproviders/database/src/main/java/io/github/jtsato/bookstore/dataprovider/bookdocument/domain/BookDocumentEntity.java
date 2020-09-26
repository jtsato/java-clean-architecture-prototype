package io.github.jtsato.bookstore.dataprovider.bookdocument.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.github.jtsato.bookstore.dataprovider.book.domain.BookEntity;
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
@Table(name = "BOOK_DOCUMENTS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"NAME"}, name = "UN_BOOK_DOCUMENTS_NAME"),
       },       indexes = {
            @Index(columnList = "BOOK_ID", name = "IDX_BOOK_DOCUMENTS_BOOK_ID"),
            @Index(columnList = "CREATION_DATE", name = "IDX_BOOK_DOCUMENTS_CREATION_DATE"),
            @Index(columnList = "LAST_MODIFIED_DATE", name = "IDX_BOOK_DOCUMENTS_LAST_MODIFIED_DATE"),
       }
)
public class BookDocumentEntity implements Serializable {

    private static final long serialVersionUID = -1110642102201662167L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_DOCUMENT_XX_KEY", updatable = false, insertable = false)
    private Long xxKey;

    @JoinColumn(name = "BOOK_ID", foreignKey = @ForeignKey(name = "FK_BOOK_DOCUMENTS_BOOK_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BookEntity book;

    @Column(name = "CONTENT_TYPE", nullable = false)
    private String contentType;

    @Column(name = "EXTENSION", nullable = false)
    private String extension;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SIZE", nullable = false)
    private Long size;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

    @Override
    public int hashCode() {
        final int prime = 23;
        int result = 1;
        result = prime * result + (xxKey == null ? 0 : xxKey.hashCode());
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
        final BookDocumentEntity other = (BookDocumentEntity) obj;
        if (xxKey == null) {
            if (other.xxKey != null) {
                return false;
            }
        } else if (!xxKey.equals(other.xxKey)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BookDocument [xxKey=");
        builder.append(xxKey);
        builder.append(", contentType=");
        builder.append(contentType);
        builder.append(", extension=");
        builder.append(extension);
        builder.append(", name=");
        builder.append(name);
        builder.append(", size=");
        builder.append(size);
        builder.append(", content=");
        builder.append(content);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", lastModifiedDate=");
        builder.append(lastModifiedDate);
        builder.append("]");
        return builder.toString();
    }
}

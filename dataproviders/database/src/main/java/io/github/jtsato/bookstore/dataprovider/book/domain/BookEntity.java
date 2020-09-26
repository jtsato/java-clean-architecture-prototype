package io.github.jtsato.bookstore.dataprovider.book.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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

import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;
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
@Table(name = "BOOKS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"EXTERNAL_ID"}, name = "UN_BOOKS_EXTERNAL_ID"),
            @UniqueConstraint(columnNames = {"TITLE"}, name = "UN_BOOKS_TITLE"),
            @UniqueConstraint(columnNames = {"ISBN"}, name = "UN_BOOKS_ISBN"),
       },       indexes = {
            @Index(columnList = "AUTHOR_ID", name = "IDX_BOOKS_AUTHOR_ID"),
            @Index(columnList = "AVAILABLE", name = "IDX_BOOKS_AVAILABLE"),
            @Index(columnList = "CREATED_DATE_TIME", name = "IDX_BOOKS_CREATED_DATE_TIME"),
            @Index(columnList = "LAST_MODIFIED_DATE_TIME", name = "IDX_BOOKS_LAST_MODIFIED_DATE_TIME"),
       }
)
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -3295200210266665685L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_BOOKS_AUTHOR_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AuthorEntity author;

    @Column(name = "EXTERNAL_ID", nullable = false)
    private Long externalId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AVAILABLE", nullable = false)
    private Boolean available;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "CREATED_DATE_TIME")
    private LocalDateTime createdDateTime;

    @Column(name = "LAST_MODIFIED_DATE_TIME")
    private LocalDateTime lastModifiedDateTime;

    @Column(name = "ISBN", nullable = false)
    private String isbn;

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
        final BookEntity other = (BookEntity) obj;
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
        builder.append("Book [id=");
        builder.append(id);
        builder.append(", externalId=");
        builder.append(externalId);
        builder.append(", title=");
        builder.append(title);
        builder.append(", available=");
        builder.append(available);
        builder.append(", price=");
        builder.append(price);
        builder.append(", createdDateTime=");
        builder.append(createdDateTime);
        builder.append(", lastModifiedDateTime=");
        builder.append(lastModifiedDateTime);
        builder.append(", isbn=");
        builder.append(isbn);
        builder.append("]");
        return builder.toString();
    }
}

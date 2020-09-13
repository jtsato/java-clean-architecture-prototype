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
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "BOOKS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"TITLE"}, name = "UN_BOOKS_TITLE"),
       },
       indexes = {
            @Index(columnList = "AVAILABLE", name = "IDX_BOOKS_AVAILABLE"),
            @Index(columnList = "CREATED_DATE", name = "IDX_BOOKS_CREATED_DATE"),
            @Index(columnList = "LAST_MODIFIED_DATE", name = "IDX_BOOKS_LAST_MODIFIED_DATE"),
       }
)
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -8420704566593238819L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_BOOKS_AUTHOR_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AuthorEntity author;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "AVAILABLE", nullable = false)
    private Boolean available;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private LocalDateTime lastModifiedDate;
}

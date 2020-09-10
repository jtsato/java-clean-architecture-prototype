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

import io.github.jtsato.bookstore.core.author.domain.Author;
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
            @UniqueConstraint(columnNames = {"ID"}, name = "UN_BOOKS_ID"),
       },
       indexes = {
            @Index(columnList = "ID", name = "IDX_BOOKS_ID"),
            @Index(columnList = "AUTHOR", name = "IDX_BOOKS_AUTHOR"),
            @Index(columnList = "TITLE", name = "IDX_BOOKS_TITLE"),
            @Index(columnList = "PRICE", name = "IDX_BOOKS_PRICE"),
            @Index(columnList = "AVAILABLE", name = "IDX_BOOKS_AVAILABLE"),
            @Index(columnList = "CREATIONDATE", name = "IDX_BOOKS_CREATIONDATE"),
            @Index(columnList = "UPDATEDATE", name = "IDX_BOOKS_UPDATEDATE"),
       }
)
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 8324584328225835766L;

    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_BOOKS_AUTHOR_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Author author;

    @Column(name = "TITLE ", nullable = false)
    private String title;

    @Column(name = "PRICE ", nullable = false)
    private BigDecimal price;

    @Column(name = "AVAILABLE ", nullable = false)
    private boolean available;

    @Column(name = "CREATION_DATE ", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_DATE ", nullable = false)
    private LocalDateTime updateDate;
}

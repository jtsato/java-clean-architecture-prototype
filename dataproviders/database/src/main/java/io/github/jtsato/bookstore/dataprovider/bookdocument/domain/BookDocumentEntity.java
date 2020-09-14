package io.github.jtsato.bookstore.dataprovider.bookdocument.domain;

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
import javax.persistence.UniqueConstraint;

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
@Table(name = "BOOK_DOCUMENTS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"NAME"}, name = "UN_BOOK_DOCUMENTS_NAME"),
       },
       indexes = {
            @Index(columnList = "CREATION_DATE", name = "IDX_BOOK_DOCUMENTS_CREATION_DATE"),
            @Index(columnList = "LAST_MODIFIED_DATE", name = "IDX_BOOK_DOCUMENTS_LAST_MODIFIED_DATE"),
       }
)
public class BookDocumentEntity implements Serializable {

    private static final long serialVersionUID = 4549476855745890942L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_DOCUMENT_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "BOOK_ID", nullable = false)
    private Long bookId;

    @Column(name = "CONTENT_TYPE", nullable = false)
    private String contentType;

    @Column(name = "EXTENSION", nullable = false)
    private String extension;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SIZE", nullable = false)
    private Long size;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private LocalDateTime lastModifiedDate;
}

package io.github.jtsato.bookstore.core.bookdocument.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.common.validation.LocalDateTimeConstraint;
import io.github.jtsato.bookstore.core.common.validation.SelfValidating;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class SearchBookDocumentsParameters extends SelfValidating<SearchBookDocumentsParameters> implements Serializable {

    private static final long serialVersionUID = -2458692565741975757L;

    private Long id;

    private Long bookId;

    private String contentType;

    private String extension;

    private String name;

    private long size;

    private String content;

    @LocalDateTimeConstraint(message = "validation.book.document.start.creation.date.invalid")
    private String startCreationDate;

    @LocalDateTimeConstraint(message = "validation.book.document.end.creation.date.invalid")
    private String endCreationDate;

    @LocalDateTimeConstraint(message = "validation.book.document.start.last.modified.date.invalid")
    private String startLastModifiedDate;

    @LocalDateTimeConstraint(message = "validation.book.document.end.last.modified.date.invalid")
    private String endLastModifiedDate;

    public SearchBookDocumentsParameters(final Long id,
                                         final Long bookId,
                                         final String contentType,
                                         final String extension,
                                         final String name,
                                         final Long size,
                                         final String content,
                                         final ImmutablePair<String, String> creationDateRange,
                                         final ImmutablePair<String, String> lastModifiedDateRange) {
        this.id = id;
        this.bookId = bookId;
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.size = size;
        this.content = content;
        this.startCreationDate = creationDateRange.getLeft();
        this.endCreationDate = creationDateRange.getRight();
        this.startLastModifiedDate = lastModifiedDateRange.getLeft();
        this.endLastModifiedDate = lastModifiedDateRange.getRight();
        this.validateSelf();
    }
}
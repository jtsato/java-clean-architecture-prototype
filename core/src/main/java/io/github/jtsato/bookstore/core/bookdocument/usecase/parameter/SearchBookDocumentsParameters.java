package io.github.jtsato.bookstore.core.bookdocument.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.book.usecase.parameter.SearchBooksParameters;
import io.github.jtsato.bookstore.core.common.validation.LocalDateConstraint;
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

    private static final long serialVersionUID = 1315805981937584025L;

    private Long xxKey;

    private SearchBooksParameters searchBooksParameters;

    private Long startSize;

    private Long endSize;

    private String contentType;

    private String extension;

    private String name;

    private String content;

    @LocalDateConstraint(message = "validation.book.document.start.creation.date.invalid")
    private String startCreationDate;

    @LocalDateConstraint(message = "validation.book.document.end.creation.date.invalid")
    private String endCreationDate;

    @LocalDateConstraint(message = "validation.book.document.start.last.modified.date.invalid")
    private String startLastModifiedDate;

    @LocalDateConstraint(message = "validation.book.document.end.last.modified.date.invalid")
    private String endLastModifiedDate;

    public SearchBookDocumentsParameters(final Long xxKey,
                                         final SearchBooksParameters searchBooksParameters,
                                         final ImmutablePair<Long, Long> sizeRange,
                                         final String contentType,
                                         final String extension,
                                         final String name,
                                         final String content,
                                         final ImmutablePair<String, String> creationDateRange,
                                         final ImmutablePair<String, String> lastModifiedDateRange) {
        this.xxKey = xxKey;
        this.searchBooksParameters = searchBooksParameters;
        this.startSize = sizeRange.getLeft();
        this.endSize = sizeRange.getRight();
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.content = content;
        this.startCreationDate = creationDateRange.getLeft();
        this.endCreationDate = creationDateRange.getRight();
        this.startLastModifiedDate = lastModifiedDateRange.getLeft();
        this.endLastModifiedDate = lastModifiedDateRange.getRight();
        this.validateSelf();
    }
}
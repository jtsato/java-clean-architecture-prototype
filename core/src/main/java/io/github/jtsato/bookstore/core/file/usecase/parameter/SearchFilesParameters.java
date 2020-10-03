package io.github.jtsato.bookstore.core.file.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

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
public class SearchFilesParameters extends SelfValidating<SearchFilesParameters> implements Serializable {

    private static final long serialVersionUID = 2710593180504768935L;

    private Long id;

    private Long startSize;

    private Long endSize;

    private String contentType;

    private String extension;

    private String name;

    private String content;

    private String url;

    @LocalDateConstraint(message = "validation.file.start.creation.date.invalid")
    private String startCreationDate;

    @LocalDateConstraint(message = "validation.file.end.creation.date.invalid")
    private String endCreationDate;

    @LocalDateConstraint(message = "validation.file.start.last.modified.date.invalid")
    private String startLastModifiedDate;

    @LocalDateConstraint(message = "validation.file.end.last.modified.date.invalid")
    private String endLastModifiedDate;

    public SearchFilesParameters(final Long id,
                                 final ImmutablePair<Long, Long> sizeRange,
                                 final String contentType,
                                 final String extension,
                                 final String name,
                                 final String content,
                                 final String url,
                                 final ImmutablePair<String, String> creationDateRange,
                                 final ImmutablePair<String, String> lastModifiedDateRange) {
        this.id = id;
        this.startSize = sizeRange.getLeft();
        this.endSize = sizeRange.getRight();
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.content = content;
        this.url = url;
        this.startCreationDate = creationDateRange.getLeft();
        this.endCreationDate = creationDateRange.getRight();
        this.startLastModifiedDate = lastModifiedDateRange.getLeft();
        this.endLastModifiedDate = lastModifiedDateRange.getRight();
        this.validateSelf();
    }
}
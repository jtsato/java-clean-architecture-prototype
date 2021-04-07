package io.github.jtsato.bookstore.core.documenttype.usecase.parameter;

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
public class SearchDocumentTypesParameters extends SelfValidating<SearchDocumentTypesParameters> implements Serializable {

    private static final long serialVersionUID = 1632537650381146000L;

    private Long id;

    private String country;

    private String description;

    @LocalDateTimeConstraint(message = "validation.document.type.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.document.type.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.document.type.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.document.type.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchDocumentTypesParameters(final Long id,
                                         final String country,
                                         final String description,
                                         final ImmutablePair<String, String> createdDateTimeRange,
                                         final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.country = country;
        this.description = description;
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
package io.github.jtsato.bookstore.core.language.usecase.parameter;

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
public class SearchLanguagesParameters extends SelfValidating<SearchLanguagesParameters> implements Serializable {

    private static final long serialVersionUID = 5237875794916754265L;

    private Long id;

    private String name;

    @LocalDateTimeConstraint(message = "validation.language.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.language.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.language.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.language.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchLanguagesParameters(final Long id,
                                     final String name,
                                     final ImmutablePair<String, String> createdDateTimeRange,
                                     final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.name = name;
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
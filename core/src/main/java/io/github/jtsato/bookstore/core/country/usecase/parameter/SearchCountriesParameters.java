package io.github.jtsato.bookstore.core.country.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.language.usecase.parameter.SearchLanguagesParameters;
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
public class SearchCountriesParameters extends SelfValidating<SearchCountriesParameters> implements Serializable {

    private static final long serialVersionUID = 7033713702029838806L;

    private Long id;

    private SearchLanguagesParameters searchLanguagesParameters;

    private String name;

    @LocalDateTimeConstraint(message = "validation.country.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.country.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.country.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.country.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchCountriesParameters(final Long id,
                                     final SearchLanguagesParameters searchLanguagesParameters,
                                     final String name,
                                     final ImmutablePair<String, String> createdDateTimeRange,
                                     final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.searchLanguagesParameters = searchLanguagesParameters;
        this.name = name;
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
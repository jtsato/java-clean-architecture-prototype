package io.github.jtsato.bookstore.core.education.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
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
public class SearchEducationsParameters extends SelfValidating<SearchEducationsParameters> implements Serializable {

    private static final long serialVersionUID = -5567529600980464088L;

    private Long id;

    private SearchCountriesParameters searchCountriesParameters;

    private String description;

    @LocalDateTimeConstraint(message = "validation.education.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.education.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.education.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.education.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchEducationsParameters(final Long id,
                                      final SearchCountriesParameters searchCountriesParameters,
                                      final String description,
                                      final ImmutablePair<String, String> createdDateTimeRange,
                                      final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.searchCountriesParameters = searchCountriesParameters;
        this.description = description;
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
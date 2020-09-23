package io.github.jtsato.bookstore.core.book.usecase.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.author.usecase.parameter.SearchAuthorsParameters;
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
public class SearchBooksParameters extends SelfValidating<SearchBooksParameters> implements Serializable {

    private static final long serialVersionUID = -2174679835105345079L;

    private Long id;

    private SearchAuthorsParameters searchAuthorsParameters;

    private String title;

    private Boolean available;

    @LocalDateTimeConstraint(message = "validation.book.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.book.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.book.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.book.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    private BigDecimal startPrice;

    private BigDecimal endPrice;

    public SearchBooksParameters(final Long id,
                                 final SearchAuthorsParameters searchAuthorsParameters,
                                 final String title,
                                 final Boolean available,
                                 final ImmutablePair<String, String> createdDateTimeRange,
                                 final ImmutablePair<String, String> lastModifiedDateTimeRange,
                                 final ImmutablePair<BigDecimal, BigDecimal> priceRange) {
        this.id = id;
        this.searchAuthorsParameters = searchAuthorsParameters;
        this.title = title;
        this.available = available;
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.startPrice = priceRange.getLeft();
        this.endPrice = priceRange.getRight();
        this.validateSelf();
    }
}
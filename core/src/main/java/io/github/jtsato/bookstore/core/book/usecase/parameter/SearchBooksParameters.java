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
public class SearchBooksParameters extends SelfValidating<SearchBooksParameters>  implements Serializable {

    private static final long serialVersionUID = -3987839404673579136L;

    private Long id;

    private SearchAuthorsParameters searchAuthorsParameters;

    private String title;

    private BigDecimal startPrice;

    private BigDecimal endPrice;

    private Boolean available;

    @LocalDateTimeConstraint(message = "validation.book.start.created.date.invalid")
    private String startCreatedDate;

    @LocalDateTimeConstraint(message = "validation.book.end.created.date.invalid")
    private String endCreatedDate;

    @LocalDateTimeConstraint(message = "validation.book.start.last.modified.date.invalid")
    private String startLastModifiedDate;

    @LocalDateTimeConstraint(message = "validation.book.end.last.modified.date.invalid")
    private String endLastModifiedDate;

    public SearchBooksParameters(final Long id,
                                 final SearchAuthorsParameters searchAuthorsParameters,
                                 final String title,
                                 final ImmutablePair<BigDecimal, BigDecimal> priceRange,
                                 final Boolean available,
                                 final ImmutablePair<String, String> createdDateRange,
                                 final ImmutablePair<String, String> lastModifiedDateRange) {
        this.id = id;
        this.searchAuthorsParameters = searchAuthorsParameters;
        this.title = title;
        this.startPrice = priceRange.getLeft();
        this.endPrice = priceRange.getRight();
        this.available = available;
        this.startCreatedDate = createdDateRange.getLeft();
        this.endCreatedDate = createdDateRange.getRight();
        this.startLastModifiedDate = lastModifiedDateRange.getLeft();
        this.endLastModifiedDate = lastModifiedDateRange.getRight();
        this.validateSelf();
    }
}
package io.github.jtsato.bookstore.core.jobinformation.usecase.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.common.validation.LocalDateConstraint;
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
public class SearchJobInformationsParameters extends SelfValidating<SearchJobInformationsParameters> implements Serializable {

    private static final long serialVersionUID = 3419402346214345074L;

    private Long id;

    private SearchLeadsParameters searchLeadsParameters;

    private Long startAttach;

    private Long endAttach;

    private String profession;

    private String referenceMonth;

    private String receiptType;

    @LocalDateConstraint(message = "validation.job.information.start.start.date.invalid")
    private String startStartDate;

    @LocalDateConstraint(message = "validation.job.information.end.start.date.invalid")
    private String endStartDate;

    @LocalDateTimeConstraint(message = "validation.job.information.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.job.information.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.job.information.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.job.information.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    private BigDecimal startMonthlyIncome;

    private BigDecimal endMonthlyIncome;

    public SearchJobInformationsParameters(final Long id,
                                           final SearchLeadsParameters searchLeadsParameters,
                                           final ImmutablePair<Long, Long> attachRange,
                                           final String profession,
                                           final String referenceMonth,
                                           final String receiptType,
                                           final ImmutablePair<String, String> startDateRange,
                                           final ImmutablePair<String, String> createdDateTimeRange,
                                           final ImmutablePair<String, String> lastModifiedDateTimeRange,
                                           final ImmutablePair<BigDecimal, BigDecimal> monthlyIncomeRange) {
        this.id = id;
        this.searchLeadsParameters = searchLeadsParameters;
        this.startAttach = attachRange.getLeft();
        this.endAttach = attachRange.getRight();
        this.profession = profession;
        this.referenceMonth = referenceMonth;
        this.receiptType = receiptType;
        this.startStartDate = startDateRange.getLeft();
        this.endStartDate = startDateRange.getRight();
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.startMonthlyIncome = monthlyIncomeRange.getLeft();
        this.endMonthlyIncome = monthlyIncomeRange.getRight();
        this.validateSelf();
    }
}
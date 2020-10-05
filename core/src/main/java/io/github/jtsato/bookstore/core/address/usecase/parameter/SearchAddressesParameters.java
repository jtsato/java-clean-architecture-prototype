package io.github.jtsato.bookstore.core.address.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
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
public class SearchAddressesParameters extends SelfValidating<SearchAddressesParameters> implements Serializable {

    private static final long serialVersionUID = -12756463493757141L;

    private Long id;

    private SearchLeadsParameters searchLeadsParameters;

    private String zipCode;

    private String city;

    private String state;

    private String country;

    private String description;

    private String complement;

    private String number;

    private String type;

    @LocalDateTimeConstraint(message = "validation.address.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.address.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.address.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.address.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchAddressesParameters(final Long id,
                                     final SearchLeadsParameters searchLeadsParameters,
                                     final String zipCode,
                                     final String city,
                                     final String state,
                                     final String country,
                                     final String description,
                                     final String complement,
                                     final String number,
                                     final String type,
                                     final ImmutablePair<String, String> createdDateTimeRange,
                                     final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.searchLeadsParameters = searchLeadsParameters;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.description = description;
        this.complement = complement;
        this.number = number;
        this.type = type;
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
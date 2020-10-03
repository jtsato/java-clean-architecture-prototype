package io.github.jtsato.bookstore.core.document.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
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
public class SearchDocumentsParameters extends SelfValidating<SearchDocumentsParameters> implements Serializable {

    private static final long serialVersionUID = 2395528936332607641L;

    private Long id;

    private SearchLeadsParameters searchLeadsParameters;

    private SearchDocumentTypesParameters searchDocumentTypesParameters;

    private Long startFrontPhoto;

    private Long endFrontPhoto;

    private Long startBackPhoto;

    private Long endBackPhoto;

    private String number;

    private String issuer;

    private String state;

    @LocalDateConstraint(message = "validation.document.start.issue.date.invalid")
    private String startIssueDate;

    @LocalDateConstraint(message = "validation.document.end.issue.date.invalid")
    private String endIssueDate;

    @LocalDateTimeConstraint(message = "validation.document.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.document.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.document.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.document.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchDocumentsParameters(final Long id,
                                     final SearchLeadsParameters searchLeadsParameters,
                                     final SearchDocumentTypesParameters searchDocumentTypesParameters,
                                     final ImmutablePair<Long, Long> frontPhotoRange,
                                     final ImmutablePair<Long, Long> backPhotoRange,
                                     final String number,
                                     final String issuer,
                                     final String state,
                                     final ImmutablePair<String, String> issueDateRange,
                                     final ImmutablePair<String, String> createdDateTimeRange,
                                     final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.searchLeadsParameters = searchLeadsParameters;
        this.searchDocumentTypesParameters = searchDocumentTypesParameters;
        this.startFrontPhoto = frontPhotoRange.getLeft();
        this.endFrontPhoto = frontPhotoRange.getRight();
        this.startBackPhoto = backPhotoRange.getLeft();
        this.endBackPhoto = backPhotoRange.getRight();
        this.number = number;
        this.issuer = issuer;
        this.state = state;
        this.startIssueDate = issueDateRange.getLeft();
        this.endIssueDate = issueDateRange.getRight();
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
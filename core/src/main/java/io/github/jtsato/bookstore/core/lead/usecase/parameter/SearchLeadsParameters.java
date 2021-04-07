package io.github.jtsato.bookstore.core.lead.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

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
public class SearchLeadsParameters extends SelfValidating<SearchLeadsParameters> implements Serializable {

    private static final long serialVersionUID = -3599370187691310780L;

    private Long id;

    private Long startSelfiePhoto;

    private Long endSelfiePhoto;

    private String cpf;

    private String cellphone;

    private String name;

    private String motherFullName;

    private String gender;

    private String education;

    private String maritalStatus;

    private Boolean stableUnion;

    @LocalDateConstraint(message = "validation.lead.start.birthdate.invalid")
    private String startBirthdate;

    @LocalDateConstraint(message = "validation.lead.end.birthdate.invalid")
    private String endBirthdate;

    @LocalDateTimeConstraint(message = "validation.lead.start.created.date.time.invalid")
    private String startCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.lead.end.created.date.time.invalid")
    private String endCreatedDateTime;

    @LocalDateTimeConstraint(message = "validation.lead.start.last.modified.date.time.invalid")
    private String startLastModifiedDateTime;

    @LocalDateTimeConstraint(message = "validation.lead.end.last.modified.date.time.invalid")
    private String endLastModifiedDateTime;

    public SearchLeadsParameters(final Long id,
                                 final ImmutablePair<Long, Long> selfiePhotoRange,
                                 final String cpf,
                                 final String cellphone,
                                 final String name,
                                 final String motherFullName,
                                 final String gender,
                                 final String education,
                                 final String maritalStatus,
                                 final Boolean stableUnion,
                                 final ImmutablePair<String, String> birthdateRange,
                                 final ImmutablePair<String, String> createdDateTimeRange,
                                 final ImmutablePair<String, String> lastModifiedDateTimeRange) {
        this.id = id;
        this.startSelfiePhoto = selfiePhotoRange.getLeft();
        this.endSelfiePhoto = selfiePhotoRange.getRight();
        this.cpf = cpf;
        this.cellphone = cellphone;
        this.name = name;
        this.motherFullName = motherFullName;
        this.gender = gender;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.stableUnion = stableUnion;
        this.startBirthdate = birthdateRange.getLeft();
        this.endBirthdate = birthdateRange.getRight();
        this.startCreatedDateTime = createdDateTimeRange.getLeft();
        this.endCreatedDateTime = createdDateTimeRange.getRight();
        this.startLastModifiedDateTime = lastModifiedDateTimeRange.getLeft();
        this.endLastModifiedDateTime = lastModifiedDateTimeRange.getRight();
        this.validateSelf();
    }
}
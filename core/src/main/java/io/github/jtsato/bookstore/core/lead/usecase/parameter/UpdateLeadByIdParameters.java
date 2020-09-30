package io.github.jtsato.bookstore.core.lead.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class UpdateLeadByIdParameters extends SelfValidating<UpdateLeadByIdParameters> implements Serializable {

    private static final long serialVersionUID = 1007372346560955502L;

    @NotNull(message = "validation.lead.id.null")
    private Long id;

    @NotNull(message = "validation.lead.selfie.photo.null")
    private final Long selfiePhoto;

    @NotBlank(message = "validation.lead.cpf.blank")
    private final String cpf;

    @NotBlank(message = "validation.lead.cellphone.blank")
    private final String cellphone;

    @NotBlank(message = "validation.lead.name.blank")
    private final String name;

    @NotBlank(message = "validation.lead.mother.full.name.blank")
    private final String motherFullName;

    @NotBlank(message = "validation.lead.gender.blank")
    private final String gender;

    @NotBlank(message = "validation.lead.education.blank")
    private final String education;

    @NotBlank(message = "validation.lead.marital.status.blank")
    private final String maritalStatus;

    @NotNull(message = "validation.lead.stable.union.null")
    private final Boolean stableUnion;

    @NotBlank(message = "validation.lead.birthdate.blank")
    @LocalDateConstraint(message = "validation.lead.birthdate.invalid")
    private final String birthdate;

    @LocalDateTimeConstraint(message = "validation.lead.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.lead.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public UpdateLeadByIdParameters(final Long id,
                                    final Long selfiePhoto,
                                    final String cpf,
                                    final String cellphone,
                                    final String name,
                                    final String motherFullName,
                                    final String gender,
                                    final String education,
                                    final String maritalStatus,
                                    final Boolean stableUnion,
                                    final String birthdate,
                                    final String createdDateTime,
                                    final String lastModifiedDateTime) {
        this.id = id;
        this.selfiePhoto = selfiePhoto;
        this.cpf = cpf;
        this.cellphone = cellphone;
        this.name = name;
        this.motherFullName = motherFullName;
        this.gender = gender;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.stableUnion = stableUnion;
        this.birthdate = birthdate;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.validateSelf();
    }
}

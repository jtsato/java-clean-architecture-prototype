package io.github.jtsato.bookstore.core.education.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class UpdateEducationByIdParameters extends SelfValidating<UpdateEducationByIdParameters> implements Serializable {

    private static final long serialVersionUID = 373151997066495249L;

    @NotNull(message = "validation.education.id.null")
    private Long id;

    @NotNull(message = "validation.country.id.null")
    private final Long countryId;

    @NotBlank(message = "validation.education.description.blank")
    private final String description;

    @LocalDateTimeConstraint(message = "validation.education.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.education.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public UpdateEducationByIdParameters(final Long id,
                                         final Long countryId,
                                         final String description,
                                         final String createdDateTime,
                                         final String lastModifiedDateTime) {
        this.id = id;
        this.countryId = countryId;
        this.description = description;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.validateSelf();
    }
}

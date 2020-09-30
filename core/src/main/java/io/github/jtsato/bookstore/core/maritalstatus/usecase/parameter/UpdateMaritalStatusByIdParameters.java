package io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter;

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
public class UpdateMaritalStatusByIdParameters extends SelfValidating<UpdateMaritalStatusByIdParameters> implements Serializable {

    private static final long serialVersionUID = 7460001129937192738L;

    @NotNull(message = "validation.marital.status.id.null")
    private Long id;

    @NotNull(message = "validation.country.id.null")
    private final Long countryId;

    @NotBlank(message = "validation.marital.status.description.blank")
    private final String description;

    @LocalDateTimeConstraint(message = "validation.marital.status.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.marital.status.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public UpdateMaritalStatusByIdParameters(final Long id,
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

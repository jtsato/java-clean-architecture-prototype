package io.github.jtsato.bookstore.core.country.usecase.parameter;

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
public class RegisterCountryParameters extends SelfValidating<RegisterCountryParameters> implements Serializable {

    private static final long serialVersionUID = -2825734940071604238L;

    @NotNull(message = "validation.language.id.null")
    private final Long languageId;

    @NotBlank(message = "validation.country.name.blank")
    private final String name;

    @LocalDateTimeConstraint(message = "validation.country.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.country.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public RegisterCountryParameters(final Long languageId,
                                     final String name,
                                     final String createdDateTime,
                                     final String lastModifiedDateTime) {
        this.languageId = languageId;
        this.name = name;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.validateSelf();
    }
}

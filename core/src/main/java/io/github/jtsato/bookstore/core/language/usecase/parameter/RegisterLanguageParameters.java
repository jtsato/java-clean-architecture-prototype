package io.github.jtsato.bookstore.core.language.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

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
public class RegisterLanguageParameters extends SelfValidating<RegisterLanguageParameters> implements Serializable {

    private static final long serialVersionUID = -4136798090557699015L;

    @NotBlank(message = "validation.language.name.blank")
    private final String name;

    @LocalDateTimeConstraint(message = "validation.language.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.language.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public RegisterLanguageParameters(final String name,
                                      final String createdDateTime,
                                      final String lastModifiedDateTime) {
        this.name = name;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.validateSelf();
    }
}

package io.github.jtsato.bookstore.core.language.usecase.parameter;

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
public class UpdateLanguageByIdParameters extends SelfValidating<UpdateLanguageByIdParameters> implements Serializable {

    private static final long serialVersionUID = -5725140515119677169L;

    @NotNull(message = "validation.language.id.null")
    private Long id;

    @NotBlank(message = "validation.language.name.blank")
    private final String name;

    @LocalDateTimeConstraint(message = "validation.language.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.language.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public UpdateLanguageByIdParameters(final Long id,
                                        final String name,
                                        final String createdDateTime,
                                        final String lastModifiedDateTime) {
        this.id = id;
        this.name = name;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.validateSelf();
    }
}

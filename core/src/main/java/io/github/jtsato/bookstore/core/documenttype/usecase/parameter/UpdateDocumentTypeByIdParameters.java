package io.github.jtsato.bookstore.core.documenttype.usecase.parameter;

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
public class UpdateDocumentTypeByIdParameters extends SelfValidating<UpdateDocumentTypeByIdParameters> implements Serializable {

    private static final long serialVersionUID = 8206060772650469780L;

    @NotNull(message = "validation.document.type.id.null")
    private Long id;

    @NotBlank(message = "validation.document.type.country.blank")
    private final String country;

    @NotBlank(message = "validation.document.type.description.blank")
    private final String description;

    @LocalDateTimeConstraint(message = "validation.document.type.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.document.type.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    public UpdateDocumentTypeByIdParameters(final Long id,
                                            final String country,
                                            final String description,
                                            final String createdDateTime,
                                            final String lastModifiedDateTime) {
        this.id = id;
        this.country = country;
        this.description = description;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.validateSelf();
    }
}

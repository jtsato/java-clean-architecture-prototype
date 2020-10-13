package io.github.jtsato.bookstore.core.documenttype.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    private static final long serialVersionUID = 3065391468871632187L;

    @NotNull(message = "validation.document.type.id.null")
    private Long id;

    @NotBlank(message = "validation.document.type.country.blank")
    private final String country;

    @NotBlank(message = "validation.document.type.description.blank")
    private final String description;

    public UpdateDocumentTypeByIdParameters(final Long id,
                                            final String country,
                                            final String description) {
        this.id = id;
        this.country = country;
        this.description = description;
        this.validateSelf();
    }
}

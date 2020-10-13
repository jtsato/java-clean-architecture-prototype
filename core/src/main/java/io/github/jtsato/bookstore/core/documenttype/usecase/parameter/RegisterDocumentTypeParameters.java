package io.github.jtsato.bookstore.core.documenttype.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
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
public class RegisterDocumentTypeParameters extends SelfValidating<RegisterDocumentTypeParameters> implements Serializable {

    private static final long serialVersionUID = -5125731644013591504L;

    @NotBlank(message = "validation.document.type.country.blank")
    private final String country;

    @NotBlank(message = "validation.document.type.description.blank")
    private final String description;

    public RegisterDocumentTypeParameters(final String country,
                                          final String description) {
        this.country = country;
        this.description = description;
        this.validateSelf();
    }
}

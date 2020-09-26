package io.github.jtsato.bookstore.core.country.usecase.parameter;

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
public class UpdateCountryByIdParameters extends SelfValidating<UpdateCountryByIdParameters> implements Serializable {

    private static final long serialVersionUID = -4791521345816932925L;

    @NotNull(message = "validation.country.id.null")
    private Long id;

    @NotBlank(message = "validation.country.name.blank")
    private final String name;

    public UpdateCountryByIdParameters(final Long id,
                                       final String name) {
        this.id = id;
        this.name = name;
        this.validateSelf();
    }
}

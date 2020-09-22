package io.github.jtsato.bookstore.core.country.usecase.parameter;

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
public class RegisterCountryParameters extends SelfValidating<RegisterCountryParameters> implements Serializable {

    private static final long serialVersionUID = -501602453566894104L;

    @NotBlank(message = "validation.country.name.blank")
    private final String name;

    public RegisterCountryParameters(final String name) {
        this.name = name;
        this.validateSelf();
    }
}

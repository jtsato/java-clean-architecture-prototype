package io.github.jtsato.bookstore.core.author.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.github.jtsato.bookstore.core.common.validation.LocalDateConstraint;
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
public class UpdateAuthorByIdParameters extends SelfValidating<UpdateAuthorByIdParameters> implements Serializable {

    private static final long serialVersionUID = 8610417139397773123L;

    @NotNull(message = "validation.author.id.null")
    private Long id;

    @NotNull(message = "validation.country.id.null")
    private final Long countryId;

    @NotBlank(message = "validation.author.name.blank")
    private final String name;

    @NotBlank(message = "validation.author.gender.blank")
    private final String gender;

    @NotBlank(message = "validation.author.birthdate.blank")
    @LocalDateConstraint(message = "validation.author.birthdate.invalid")
    private final String birthdate;

    public UpdateAuthorByIdParameters(final Long id,
                                      final Long countryId,
                                      final String name,
                                      final String gender,
                                      final String birthdate) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.validateSelf();
    }
}

package io.github.jtsato.bookstore.core.address.usecase.parameter;

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
public class RegisterAddressParameters extends SelfValidating<RegisterAddressParameters> implements Serializable {

    private static final long serialVersionUID = -1160903938349970344L;

    @NotNull(message = "validation.lead.id.null")
    private final Long leadId;

    @NotBlank(message = "validation.address.zip.code.blank")
    private final String zipCode;

    @NotBlank(message = "validation.address.city.blank")
    private final String city;

    @NotBlank(message = "validation.address.state.blank")
    private final String state;

    @NotBlank(message = "validation.address.country.blank")
    private final String country;

    @NotBlank(message = "validation.address.description.blank")
    private final String description;

    private final String complement;

    @NotBlank(message = "validation.address.number.blank")
    private final String number;

    @NotBlank(message = "validation.address.property.type.blank")
    private final String propertyType;

    public RegisterAddressParameters(final Long leadId,
                                     final String zipCode,
                                     final String city,
                                     final String state,
                                     final String country,
                                     final String description,
                                     final String complement,
                                     final String number,
                                     final String propertyType) {
        this.leadId = leadId;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.description = description;
        this.complement = complement;
        this.number = number;
        this.propertyType = propertyType;
        this.validateSelf();
    }
}

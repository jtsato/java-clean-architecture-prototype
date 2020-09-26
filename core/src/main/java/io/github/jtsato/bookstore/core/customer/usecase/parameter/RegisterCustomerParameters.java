package io.github.jtsato.bookstore.core.customer.usecase.parameter;

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
public class RegisterCustomerParameters extends SelfValidating<RegisterCustomerParameters> implements Serializable {

    private static final long serialVersionUID = 933370914492203166L;

    @NotBlank(message = "validation.customer.name.blank")
    private final String name;

    @NotBlank(message = "validation.customer.address.blank")
    private final String address;

    public RegisterCustomerParameters(final String name,
                                      final String address) {
        this.name = name;
        this.address = address;
        this.validateSelf();
    }
}

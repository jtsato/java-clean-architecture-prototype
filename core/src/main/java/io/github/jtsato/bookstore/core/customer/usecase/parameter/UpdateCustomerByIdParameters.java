package io.github.jtsato.bookstore.core.customer.usecase.parameter;

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
public class UpdateCustomerByIdParameters extends SelfValidating<UpdateCustomerByIdParameters> implements Serializable {

    private static final long serialVersionUID = -6999737773648032590L;

    @NotNull(message = "validation.customer.id.null")
    private Long id;

    @NotBlank(message = "validation.customer.name.blank")
    private final String name;

    @NotBlank(message = "validation.customer.address.blank")
    private final String address;

    public UpdateCustomerByIdParameters(final Long id,
                                        final String name,
                                        final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.validateSelf();
    }
}

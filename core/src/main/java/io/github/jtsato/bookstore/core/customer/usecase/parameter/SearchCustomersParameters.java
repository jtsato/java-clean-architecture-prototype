package io.github.jtsato.bookstore.core.customer.usecase.parameter;

import java.io.Serializable;
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
public class SearchCustomersParameters extends SelfValidating<SearchCustomersParameters> implements Serializable {

    private static final long serialVersionUID = 4187675836131263277L;

    private Long id;

    private String name;

    private String address;

    public SearchCustomersParameters(final Long id,
                                     final String name,
                                     final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.validateSelf();
    }
}
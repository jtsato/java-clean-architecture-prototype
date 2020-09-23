package io.github.jtsato.bookstore.core.country.usecase.parameter;

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
public class SearchCountriesParameters extends SelfValidating<SearchCountriesParameters> implements Serializable {

    private static final long serialVersionUID = -927595187471171508L;

    private Long id;

    private String name;

    public SearchCountriesParameters(final Long id,
                                     final String name) {
        this.id = id;
        this.name = name;
        this.validateSelf();
    }
}
package io.github.jtsato.bookstore.core.enumerator.usecase.parameter;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class SearchEnumeratorsParameters implements Serializable {

    private static final long serialVersionUID = 8224356016272985053L;

    private String domain;

    private String key;

    public SearchEnumeratorsParameters(final String domain, final String key) {
        this.domain = domain;
        this.key = key;
    }
}


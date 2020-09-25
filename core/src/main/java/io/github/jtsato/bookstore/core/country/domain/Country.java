package io.github.jtsato.bookstore.core.country.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Country implements Serializable {

    private static final long serialVersionUID = -1038314146073131743L;

    private final Long id;
    private final String name;
}

package io.github.jtsato.bookstore.core.author.domain;

import java.io.Serializable;
import java.time.LocalDate;

import io.github.jtsato.bookstore.core.country.domain.Country;
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
public class Author implements Serializable {

    private static final long serialVersionUID = -3077280008111242735L;

    private final Long id;
    private final Country country;
    private final String name;
    private final Gender gender;
    private final LocalDate birthdate;
}

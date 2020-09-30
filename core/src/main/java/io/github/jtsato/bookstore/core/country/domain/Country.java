package io.github.jtsato.bookstore.core.country.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.github.jtsato.bookstore.core.language.domain.Language;
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

    private static final long serialVersionUID = 7474849761830650645L;

    private final Long id;
    private final Language language;
    private final String name;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}

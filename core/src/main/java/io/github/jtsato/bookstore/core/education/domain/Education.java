package io.github.jtsato.bookstore.core.education.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Education implements Serializable {

    private static final long serialVersionUID = -5462339849995401215L;

    private final Long id;
    private final Country country;
    private final String description;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}

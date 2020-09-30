package io.github.jtsato.bookstore.core.propertytype.domain;

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
public class PropertyType implements Serializable {

    private static final long serialVersionUID = 9168532477652452708L;

    private final Long id;
    private final Country country;
    private final String description;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}

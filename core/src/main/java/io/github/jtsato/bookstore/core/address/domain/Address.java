package io.github.jtsato.bookstore.core.address.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
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
public class Address implements Serializable {

    private static final long serialVersionUID = 7521218455563816590L;

    private final Long id;
    private final Lead lead;
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;
    private final String description;
    private final String complement;
    private final String number;
    private final PropertyType propertyType;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}

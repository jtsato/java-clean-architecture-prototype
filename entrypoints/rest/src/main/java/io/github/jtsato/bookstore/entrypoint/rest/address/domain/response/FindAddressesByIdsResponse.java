package io.github.jtsato.bookstore.entrypoint.rest.address.domain.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class FindAddressesByIdsResponse implements Serializable {

    private static final long serialVersionUID = -5679238446374567781L;

    private final Long id;
    private final FindAddressesByIdsLeadResponse lead;
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;
    private final String description;
    private final String complement;
    private final String number;
    private final String type;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}

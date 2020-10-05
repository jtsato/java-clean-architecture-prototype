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
public class RegisterAddressResponse implements Serializable {

    private static final long serialVersionUID = 4098857046371420702L;

    private final Long id;
    private final RegisterAddressLeadResponse lead;
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

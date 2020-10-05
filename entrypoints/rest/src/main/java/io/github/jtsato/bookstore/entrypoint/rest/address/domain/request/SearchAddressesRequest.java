package io.github.jtsato.bookstore.entrypoint.rest.address.domain.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class SearchAddressesRequest implements Serializable {

    private static final long serialVersionUID = -769445035723636333L;

    private Long id;
    private SearchAddressesLeadRequest lead;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String description;
    private String complement;
    private String number;
    private String type;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
}

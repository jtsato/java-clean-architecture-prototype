package io.github.jtsato.bookstore.entrypoint.rest.address.domain.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAddressByIdRequest implements Serializable {

    private static final long serialVersionUID = 1993868718005437323L;

    private Long id;
    private Long leadId;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String description;
    private String complement;
    private String number;
    private String type;
    private String createdDateTime;
    private String lastModifiedDateTime;
}

package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request;

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
public class UpdateCustomerByIdRequest implements Serializable {

    private static final long serialVersionUID = -1427135480566362503L;

    private Long id;
    private String name;
    private String address;
}

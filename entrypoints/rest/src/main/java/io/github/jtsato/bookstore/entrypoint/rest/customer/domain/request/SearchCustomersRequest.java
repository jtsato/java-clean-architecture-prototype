package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request;

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
public final class SearchCustomersRequest implements Serializable {

    private static final long serialVersionUID = -6788455343707110870L;

    private Long id;
    private String name;
    private String address;
}

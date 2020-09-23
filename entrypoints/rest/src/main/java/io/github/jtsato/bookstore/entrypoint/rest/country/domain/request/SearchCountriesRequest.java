package io.github.jtsato.bookstore.entrypoint.rest.country.domain.request;

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
public final class SearchCountriesRequest implements Serializable {

    private static final long serialVersionUID = -5569440798450630169L;

    private Long id;
    private String name;
}

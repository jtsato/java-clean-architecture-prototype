package io.github.jtsato.bookstore.entrypoint.rest.country.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class FindCountriesByIdsResponse implements Serializable {

    private static final long serialVersionUID = 6417758226474026162L;

    private final Long id;
    private final String name;
}

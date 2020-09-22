package io.github.jtsato.bookstore.entrypoint.rest.country.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class RegisterCountryResponse implements Serializable {

    private static final long serialVersionUID = 9148292619549035688L;

    private final Long id;
    private final String name;
}

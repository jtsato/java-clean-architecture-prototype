package io.github.jtsato.bookstore.entrypoint.rest.author.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class FindAuthorsByIdsResponse implements Serializable {

    private static final long serialVersionUID = 4342951756989153533L;

    private final Long id;
    private final FindAuthorsByIdsCountryResponse country;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

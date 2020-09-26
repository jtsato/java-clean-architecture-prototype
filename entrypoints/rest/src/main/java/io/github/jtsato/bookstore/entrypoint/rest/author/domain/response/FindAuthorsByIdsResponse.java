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

    private static final long serialVersionUID = -1738834035843184019L;

    private final Long id;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

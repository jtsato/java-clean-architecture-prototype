package io.github.jtsato.bookstore.entrypoint.rest.book.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class GetBookByIdAuthorResponse implements Serializable {

    private static final long serialVersionUID = 1260541059487318205L;

    private final Long id;
    private final GetBookByIdAuthorCountryResponse country;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

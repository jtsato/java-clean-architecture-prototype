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
public class FindBooksByIdsAuthorResponse implements Serializable {

    private static final long serialVersionUID = -6167617941775236528L;

    private final Long id;
    private final FindBooksByIdsAuthorCountryResponse country;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

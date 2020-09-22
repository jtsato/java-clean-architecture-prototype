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
public class SearchBooksAuthorResponse implements Serializable {

    private static final long serialVersionUID = 8754727646793387023L;

    private final Long id;
    private final SearchBooksAuthorCountryResponse country;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

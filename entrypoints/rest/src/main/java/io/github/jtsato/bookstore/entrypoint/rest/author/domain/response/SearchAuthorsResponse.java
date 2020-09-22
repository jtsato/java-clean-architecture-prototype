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
public class SearchAuthorsResponse implements Serializable {

    private static final long serialVersionUID = 37546097014819126L;

    private final Long id;
    private final SearchAuthorsCountryResponse country;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

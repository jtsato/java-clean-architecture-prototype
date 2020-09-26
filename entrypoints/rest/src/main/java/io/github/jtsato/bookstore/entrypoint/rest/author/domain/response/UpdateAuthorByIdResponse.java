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
public class UpdateAuthorByIdResponse implements Serializable {

    private static final long serialVersionUID = -3433494186215649597L;

    private final Long id;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

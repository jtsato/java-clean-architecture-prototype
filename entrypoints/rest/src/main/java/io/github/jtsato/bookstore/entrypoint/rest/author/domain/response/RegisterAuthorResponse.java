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
public class RegisterAuthorResponse implements Serializable {

    private static final long serialVersionUID = 9033581111796253845L;

    private final Long id;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}

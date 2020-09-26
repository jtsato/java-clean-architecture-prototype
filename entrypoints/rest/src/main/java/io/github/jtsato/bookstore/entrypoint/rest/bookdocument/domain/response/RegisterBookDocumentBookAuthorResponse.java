package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class RegisterBookDocumentBookAuthorResponse implements Serializable {

    private static final long serialVersionUID = 2530656735466965992L;

    private final Long id;
    private final String name;
    private final String gender;
    private final LocalDate birthdate;
}
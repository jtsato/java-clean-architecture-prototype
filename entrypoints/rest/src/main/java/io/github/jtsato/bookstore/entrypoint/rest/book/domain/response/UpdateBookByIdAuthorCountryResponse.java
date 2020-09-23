package io.github.jtsato.bookstore.entrypoint.rest.book.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class UpdateBookByIdAuthorCountryResponse implements Serializable {

    private static final long serialVersionUID = -3473027912411496196L;

    private final Long id;
    private final String name;
}

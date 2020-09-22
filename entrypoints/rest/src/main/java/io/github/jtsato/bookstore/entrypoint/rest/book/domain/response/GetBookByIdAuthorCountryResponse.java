package io.github.jtsato.bookstore.entrypoint.rest.book.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class GetBookByIdAuthorCountryResponse implements Serializable {

    private static final long serialVersionUID = -7226560177539429368L;

    private final Long id;
    private final String name;
}

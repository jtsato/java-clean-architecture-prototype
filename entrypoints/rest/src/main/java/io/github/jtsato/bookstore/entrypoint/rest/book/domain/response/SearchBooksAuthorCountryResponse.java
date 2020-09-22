package io.github.jtsato.bookstore.entrypoint.rest.book.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class SearchBooksAuthorCountryResponse implements Serializable {

    private static final long serialVersionUID = -6775958613570599789L;

    private final Long id;
    private final String name;
}

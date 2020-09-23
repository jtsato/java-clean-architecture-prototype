package io.github.jtsato.bookstore.entrypoint.rest.author.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class RegisterAuthorCountryResponse implements Serializable {

    private static final long serialVersionUID = 5237488766728161068L;

    private final Long id;
    private final String name;
}

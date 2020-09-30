package io.github.jtsato.bookstore.entrypoint.rest.enumerator.domain.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class EnumeratorResponse implements Serializable {

    private static final long serialVersionUID = 2836575014712134667L;

    private final String domain;

    private final String key;

    private final String value;
}


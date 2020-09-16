package io.github.jtsato.bookstore.core.exception;

import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
public class InvalidEnumeratorException extends CoreException {

    private static final long serialVersionUID = 136576216349035246L;

    public InvalidEnumeratorException(final String message, final Object... args) {
        super(message, args);
    }
}

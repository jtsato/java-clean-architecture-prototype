package io.github.jtsato.bookstore.core.exception;

import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
public class InvalidEnumeratorException extends CoreException {

    private static final long serialVersionUID = 7393515622982765918L;

    public InvalidEnumeratorException(final String message, final Object... args) {
        super(message, args);
    }
}

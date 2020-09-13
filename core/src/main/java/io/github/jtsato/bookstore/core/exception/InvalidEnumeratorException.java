package io.github.jtsato.bookstore.core.exception;

import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
public class InvalidEnumeratorException extends CoreException {

    private static final long serialVersionUID = 3679661091841855055L;

    public InvalidEnumeratorException(final String message, final Object... args) {
        super(message, args);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 1463251997066543197L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

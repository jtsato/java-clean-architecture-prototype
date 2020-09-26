package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 2030542019953901981L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

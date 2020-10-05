package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = -8993085989361465307L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

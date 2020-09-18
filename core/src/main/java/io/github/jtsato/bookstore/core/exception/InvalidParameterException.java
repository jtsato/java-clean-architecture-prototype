package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 8744814586845282892L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = -4608319688789703263L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

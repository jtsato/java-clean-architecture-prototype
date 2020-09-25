package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 9013713200991847469L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

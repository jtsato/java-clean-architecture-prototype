package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = -7612298427452800519L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

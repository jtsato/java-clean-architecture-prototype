package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = -2596016804842879173L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 1596801606553783271L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

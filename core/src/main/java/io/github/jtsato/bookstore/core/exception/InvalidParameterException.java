package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = -1485527054709079677L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

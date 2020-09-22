package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 7196622570116170792L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

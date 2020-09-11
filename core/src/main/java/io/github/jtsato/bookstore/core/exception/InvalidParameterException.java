package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato  
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = -5836393129463231626L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

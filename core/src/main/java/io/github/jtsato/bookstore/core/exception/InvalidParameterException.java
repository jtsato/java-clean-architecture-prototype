package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class InvalidParameterException extends CoreException {

    private static final long serialVersionUID = 3726502180644474868L;

    public InvalidParameterException(final String message) {
        super(message);
    }
}

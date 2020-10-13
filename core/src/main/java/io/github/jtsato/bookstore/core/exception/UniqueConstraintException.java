package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class UniqueConstraintException extends CoreException {

    private static final long serialVersionUID = 5877727763968247745L;

    public UniqueConstraintException(final String message, final Object... args) {
        super(message, args);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato  
 */

public class UniqueConstraintException extends CoreException {

    private static final long serialVersionUID = 4904177639947521771L;

    public UniqueConstraintException(final String message, final Object... args) {
        super(message, args);
    }
}

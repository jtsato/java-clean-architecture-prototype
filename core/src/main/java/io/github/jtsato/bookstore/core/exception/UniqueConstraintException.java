package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class UniqueConstraintException extends CoreException {

    private static final long serialVersionUID = 6954240004438508243L;

    public UniqueConstraintException(final String message, final Object... args) {
        super(message, args);
    }
}

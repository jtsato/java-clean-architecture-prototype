package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class UniqueConstraintException extends CoreException {

    private static final long serialVersionUID = -6417057786334067122L;

    public UniqueConstraintException(final String message, final Object... args) {
        super(message, args);
    }
}

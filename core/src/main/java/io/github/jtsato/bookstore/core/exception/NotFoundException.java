package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class NotFoundException extends CoreException {

    private static final long serialVersionUID = -2676992716983677719L;

    public NotFoundException(final String message, final Object... args) {
        super(message, args);
    }
}

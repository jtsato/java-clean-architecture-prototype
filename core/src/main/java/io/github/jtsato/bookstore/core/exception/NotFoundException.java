package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class NotFoundException extends CoreException {

    private static final long serialVersionUID = 1180208496637986950L;

    public NotFoundException(final String message, final Object... args) {
        super(message, args);
    }
}

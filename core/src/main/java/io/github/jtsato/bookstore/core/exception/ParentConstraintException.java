package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = 4857355119525118725L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = 8609817472991643622L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = 7733353616803643995L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

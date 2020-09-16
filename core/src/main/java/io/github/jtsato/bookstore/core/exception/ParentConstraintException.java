package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -8834195434622335771L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

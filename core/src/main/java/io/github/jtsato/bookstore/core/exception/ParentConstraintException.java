package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = 5613489290516054627L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = 101858230503689017L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

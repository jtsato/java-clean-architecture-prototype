package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -2023255777948843615L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

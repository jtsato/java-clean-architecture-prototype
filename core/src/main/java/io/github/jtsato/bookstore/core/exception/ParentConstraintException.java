package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -571381893942131884L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

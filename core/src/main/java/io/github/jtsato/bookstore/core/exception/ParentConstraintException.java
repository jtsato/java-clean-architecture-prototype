package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -1107370575171728669L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

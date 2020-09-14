package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = 4350918348408442515L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

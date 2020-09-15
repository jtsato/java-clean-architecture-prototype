package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -9022497996781369025L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -3140588702637865914L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

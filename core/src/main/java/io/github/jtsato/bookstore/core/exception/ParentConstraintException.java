package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -2909141107879886700L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -9183447750774536570L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato  
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -5028139911821308489L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

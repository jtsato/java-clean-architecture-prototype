package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato  
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -8314708759712674532L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

package io.github.jtsato.bookstore.core.exception;

/**
 * @author Jorge Takeshi Sato
 */

public class ParentConstraintException extends CoreException {

    private static final long serialVersionUID = -7652498621435066683L;

    public ParentConstraintException(final String message) {
        super(message);
    }
}

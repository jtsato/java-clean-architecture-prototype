package io.github.jtsato.bookstore.core.exception;

import lombok.Getter;

/**
 * @author Jorge Takeshi Sato  
 */

@Getter
public class InvalidEnumeratorException extends CoreException {

    private static final long serialVersionUID = -5726346959906912163L;

    public InvalidEnumeratorException(final String message, final Object... args) {
        super(message, args);
    }
}

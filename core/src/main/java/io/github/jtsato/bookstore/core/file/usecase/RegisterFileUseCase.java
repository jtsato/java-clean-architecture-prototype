package io.github.jtsato.bookstore.core.file.usecase;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.parameter.RegisterFileParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterFileUseCase {

    File execute(final RegisterFileParameters parameters);
}

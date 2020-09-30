package io.github.jtsato.bookstore.core.file.usecase;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.parameter.UpdateFileByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateFileByIdUseCase {

    File execute(final UpdateFileByIdParameters parameters);
}

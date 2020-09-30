package io.github.jtsato.bookstore.core.file.usecase;

import io.github.jtsato.bookstore.core.file.domain.File;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveFileByIdUseCase {

    File execute(final Long Id);
}

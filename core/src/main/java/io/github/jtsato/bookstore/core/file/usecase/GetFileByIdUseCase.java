package io.github.jtsato.bookstore.core.file.usecase;

import io.github.jtsato.bookstore.core.file.domain.File;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetFileByIdUseCase {

    File execute(final Long Id);
}

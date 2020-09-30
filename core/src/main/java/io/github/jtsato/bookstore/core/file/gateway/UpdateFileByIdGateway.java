package io.github.jtsato.bookstore.core.file.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.file.domain.File;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateFileByIdGateway {

    Optional<File> execute(final File file);
}

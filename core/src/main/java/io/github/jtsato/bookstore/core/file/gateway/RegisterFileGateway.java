package io.github.jtsato.bookstore.core.file.gateway;

import io.github.jtsato.bookstore.core.file.domain.File;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterFileGateway {

    File execute(final File file);
}

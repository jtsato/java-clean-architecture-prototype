package io.github.jtsato.bookstore.core.file.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindFilesByIdsGateway {

    Page<File> execute(final List<Long> ids);
}

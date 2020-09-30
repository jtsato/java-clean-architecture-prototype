package io.github.jtsato.bookstore.core.maritalstatus.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindMaritalStatusesByIdsUseCase {

    Page<MaritalStatus> execute(final List<Long> ids);
}

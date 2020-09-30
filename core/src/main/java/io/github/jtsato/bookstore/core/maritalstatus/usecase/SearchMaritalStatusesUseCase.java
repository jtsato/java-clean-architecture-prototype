package io.github.jtsato.bookstore.core.maritalstatus.usecase;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.maritalstatus.usecase.parameter.SearchMaritalStatusesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchMaritalStatusesUseCase {

    Page<MaritalStatus> execute(final SearchMaritalStatusesParameters parameters, final Integer page, final Integer size, final String orderBy);
}

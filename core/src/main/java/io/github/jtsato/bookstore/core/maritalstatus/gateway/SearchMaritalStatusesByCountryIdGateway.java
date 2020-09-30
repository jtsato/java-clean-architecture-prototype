package io.github.jtsato.bookstore.core.maritalstatus.gateway;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchMaritalStatusesByCountryIdGateway {

    Page<MaritalStatus> execute(final Long countryId, final Integer pageNumber, final Integer size, final String orderBy);
}

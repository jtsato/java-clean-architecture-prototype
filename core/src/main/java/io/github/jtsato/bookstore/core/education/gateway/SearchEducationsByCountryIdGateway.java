package io.github.jtsato.bookstore.core.education.gateway;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchEducationsByCountryIdGateway {

    Page<Education> execute(final Long countryId, final Integer pageNumber, final Integer size, final String orderBy);
}

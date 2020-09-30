package io.github.jtsato.bookstore.core.jobinformation.gateway;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */
@FunctionalInterface
public interface SearchJobInformationsByLeadIdGateway {

    Page<JobInformation> execute(final Long leadId, final Integer pageNumber, final Integer size, final String orderBy);
}

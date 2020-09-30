package io.github.jtsato.bookstore.core.jobinformation.gateway;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.SearchJobInformationsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchJobInformationsGateway {

    Page<JobInformation> execute(final SearchJobInformationsParameters parameters, final Integer page, final Integer size, final String orderBy);
}

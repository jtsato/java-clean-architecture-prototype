package io.github.jtsato.bookstore.core.jobinformation.usecase;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.SearchJobInformationsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface SearchJobInformationsUseCase {

    Page<JobInformation> execute(final SearchJobInformationsParameters parameters, final Integer page, final Integer size, final String orderBy);
}

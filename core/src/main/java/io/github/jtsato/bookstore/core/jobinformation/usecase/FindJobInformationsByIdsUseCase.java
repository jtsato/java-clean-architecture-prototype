package io.github.jtsato.bookstore.core.jobinformation.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindJobInformationsByIdsUseCase {

    Page<JobInformation> execute(final List<Long> ids);
}

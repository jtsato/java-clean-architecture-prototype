package io.github.jtsato.bookstore.core.jobinformation.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindJobInformationsByIdsGateway {

    Page<JobInformation> execute(final List<Long> ids);
}

package io.github.jtsato.bookstore.core.jobinformation.gateway;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterJobInformationGateway {

    JobInformation execute(final JobInformation jobInformation);
}

package io.github.jtsato.bookstore.core.jobinformation.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetJobInformationByIdGateway {

    Optional<JobInformation> execute(final Long Id);
}
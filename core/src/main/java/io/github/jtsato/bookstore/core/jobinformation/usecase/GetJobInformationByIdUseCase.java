package io.github.jtsato.bookstore.core.jobinformation.usecase;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetJobInformationByIdUseCase {

    JobInformation execute(final Long Id);
}

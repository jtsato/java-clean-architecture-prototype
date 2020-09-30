package io.github.jtsato.bookstore.core.jobinformation.usecase;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.UpdateJobInformationByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateJobInformationByIdUseCase {

    JobInformation execute(final UpdateJobInformationByIdParameters parameters);
}

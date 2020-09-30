package io.github.jtsato.bookstore.core.jobinformation.usecase;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.RegisterJobInformationParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterJobInformationUseCase {

    JobInformation execute(final RegisterJobInformationParameters parameters);
}

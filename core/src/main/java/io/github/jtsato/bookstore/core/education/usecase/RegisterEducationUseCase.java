package io.github.jtsato.bookstore.core.education.usecase;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.usecase.parameter.RegisterEducationParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterEducationUseCase {

    Education execute(final RegisterEducationParameters parameters);
}

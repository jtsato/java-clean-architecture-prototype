package io.github.jtsato.bookstore.core.education.usecase;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.education.usecase.parameter.UpdateEducationByIdParameters;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateEducationByIdUseCase {

    Education execute(final UpdateEducationByIdParameters parameters);
}

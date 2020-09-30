package io.github.jtsato.bookstore.core.education.usecase;

import io.github.jtsato.bookstore.core.education.domain.Education;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RemoveEducationByIdUseCase {

    Education execute(final Long Id);
}

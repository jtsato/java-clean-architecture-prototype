package io.github.jtsato.bookstore.core.education.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.education.domain.Education;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface UpdateEducationByIdGateway {

    Optional<Education> execute(final Education education);
}

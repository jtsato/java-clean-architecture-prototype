package io.github.jtsato.bookstore.core.education.gateway;

import io.github.jtsato.bookstore.core.education.domain.Education;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterEducationGateway {

    Education execute(final Education education);
}

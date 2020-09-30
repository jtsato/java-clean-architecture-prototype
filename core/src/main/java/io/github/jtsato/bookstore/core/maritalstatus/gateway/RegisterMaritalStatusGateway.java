package io.github.jtsato.bookstore.core.maritalstatus.gateway;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface RegisterMaritalStatusGateway {

    MaritalStatus execute(final MaritalStatus maritalStatus);
}

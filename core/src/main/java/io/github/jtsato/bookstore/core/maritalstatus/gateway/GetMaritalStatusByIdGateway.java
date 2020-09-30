package io.github.jtsato.bookstore.core.maritalstatus.gateway;

import java.util.Optional;

import io.github.jtsato.bookstore.core.maritalstatus.domain.MaritalStatus;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetMaritalStatusByIdGateway {

    Optional<MaritalStatus> execute(final Long Id);
}
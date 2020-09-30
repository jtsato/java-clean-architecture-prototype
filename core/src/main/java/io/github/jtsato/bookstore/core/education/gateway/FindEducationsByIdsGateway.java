package io.github.jtsato.bookstore.core.education.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.education.domain.Education;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindEducationsByIdsGateway {

    Page<Education> execute(final List<Long> ids);
}

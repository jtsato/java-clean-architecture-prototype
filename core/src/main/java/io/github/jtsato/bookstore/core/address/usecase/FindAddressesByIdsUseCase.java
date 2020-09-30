package io.github.jtsato.bookstore.core.address.usecase;

import java.util.List;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindAddressesByIdsUseCase {

    Page<Address> execute(final List<Long> ids);
}

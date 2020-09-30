package io.github.jtsato.bookstore.core.address.gateway;

import java.util.List;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.common.paging.Page;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface FindAddressesByIdsGateway {

    Page<Address> execute(final List<Long> ids);
}

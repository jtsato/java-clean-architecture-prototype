package io.github.jtsato.bookstore.dataprovider.address.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.address.domain.AddressEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper(uses = {LeadMapper.class})
public interface AddressMapper {

    Address of(final AddressEntity addressEntity);

    AddressEntity of(final Address address);
}

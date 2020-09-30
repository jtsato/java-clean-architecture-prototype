package io.github.jtsato.bookstore.dataprovider.address;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.RegisterAddressGateway;
import io.github.jtsato.bookstore.dataprovider.address.domain.AddressEntity;
import io.github.jtsato.bookstore.dataprovider.address.mapper.AddressMapper;
import io.github.jtsato.bookstore.dataprovider.address.repository.AddressRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterAddressDataProvider implements RegisterAddressGateway {

    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address execute(final Address address) {
        final AddressEntity addressEntity = addressMapper.of(address);
        return addressMapper.of(addressRepository.saveAndFlush(addressEntity));
    }
}

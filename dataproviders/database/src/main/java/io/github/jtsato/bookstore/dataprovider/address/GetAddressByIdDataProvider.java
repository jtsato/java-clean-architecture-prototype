package io.github.jtsato.bookstore.dataprovider.address;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.GetAddressByIdGateway;
import io.github.jtsato.bookstore.dataprovider.address.domain.AddressEntity;
import io.github.jtsato.bookstore.dataprovider.address.mapper.AddressMapper;
import io.github.jtsato.bookstore.dataprovider.address.repository.AddressRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetAddressByIdDataProvider implements GetAddressByIdGateway {

    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Optional<Address> execute(final Long id) {
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead");
        final Optional<AddressEntity> optional = addressRepository.findById(id, entityGraph);
        return optional.map(addressMapper::of);
    }
}

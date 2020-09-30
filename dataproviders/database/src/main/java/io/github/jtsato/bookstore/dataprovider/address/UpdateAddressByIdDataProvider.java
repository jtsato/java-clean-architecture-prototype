package io.github.jtsato.bookstore.dataprovider.address;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.UpdateAddressByIdGateway;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;
import io.github.jtsato.bookstore.dataprovider.address.domain.AddressEntity;
import io.github.jtsato.bookstore.dataprovider.address.mapper.AddressMapper;
import io.github.jtsato.bookstore.dataprovider.address.repository.AddressRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateAddressByIdDataProvider implements UpdateAddressByIdGateway {

    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Optional<Address> execute(final Address address) {

        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead");
        final Optional<AddressEntity> optional = addressRepository.findById(address.getId(), entityGraph);

        return optional.map(addressEntity -> updateAddressEntity(addressEntity, address));
    }

    private Address updateAddressEntity(final AddressEntity addressEntity, final Address address) {
        updateLeadEntity(address, addressEntity);
        addressEntity.setZipCode(address.getZipCode());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setDescription(address.getDescription());
        addressEntity.setComplement(address.getComplement());
        addressEntity.setNumber(address.getNumber());
        addressEntity.setLastModifiedDateTime(address.getLastModifiedDateTime());
        addressEntity.setType(address.getType().name());
        return addressMapper.of(addressRepository.saveAndFlush(addressEntity));
    }

    private void updateLeadEntity(final Address address, final AddressEntity addressEntity) {
        final Long currentLeadId = addressEntity.getLead().getId();
        final Long newLeadId = address.getLead().getId();
        if (!newLeadId.equals(currentLeadId)) {
            leadRepository.findById(newLeadId).ifPresent(addressEntity::setLead);
        }
    }
}

package io.github.jtsato.bookstore.dataprovider.address;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.gateway.FindAddressesByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.address.domain.AddressEntity;
import io.github.jtsato.bookstore.dataprovider.address.domain.QAddressEntity;
import io.github.jtsato.bookstore.dataprovider.address.mapper.AddressMapper;
import io.github.jtsato.bookstore.dataprovider.address.repository.AddressRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindAddressesByIdsDataProvider implements FindAddressesByIdsGateway {

    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    private final PageMapper<Address, AddressEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Page<Address> execute(final List<Long> ids) {

        final BooleanExpression predicate = QAddressEntity.addressEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead");
        final org.springframework.data.domain.Page<AddressEntity> page = addressRepository.findAll(predicate, pageRequest, entityGraph);
    
        return pageMapper.of(page, addressMapper::of);
    }
}

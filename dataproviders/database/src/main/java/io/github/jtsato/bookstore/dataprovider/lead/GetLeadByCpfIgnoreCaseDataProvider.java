package io.github.jtsato.bookstore.dataprovider.lead;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByCpfIgnoreCaseGateway;
import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetLeadByCpfIgnoreCaseDataProvider implements GetLeadByCpfIgnoreCaseGateway {

    private final LeadMapper leadMapper = Mappers.getMapper(LeadMapper.class);

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Optional<Lead> execute(final String cpf) {
        final Optional<LeadEntity> optional = leadRepository.findByCpfIgnoreCase(cpf);
        return optional.map(leadMapper::of);
    }
}

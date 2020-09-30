package io.github.jtsato.bookstore.dataprovider.lead;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.RegisterLeadGateway;
import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterLeadDataProvider implements RegisterLeadGateway {

    private final LeadMapper leadMapper = Mappers.getMapper(LeadMapper.class);
    
    @Autowired
    LeadRepository leadRepository;

    @Override
    public Lead execute(final Lead lead) {
        final LeadEntity leadEntity = leadMapper.of(lead);
        return leadMapper.of(leadRepository.saveAndFlush(leadEntity));
    }
}

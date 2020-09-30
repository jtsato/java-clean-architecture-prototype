package io.github.jtsato.bookstore.dataprovider.lead;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.UpdateLeadByIdGateway;
import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateLeadByIdDataProvider implements UpdateLeadByIdGateway {

    private final LeadMapper leadMapper = Mappers.getMapper(LeadMapper.class);

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Optional<Lead> execute(final Lead lead) {

        final Optional<LeadEntity> optional = leadRepository.findById(lead.getId());

        return optional.map(leadEntity -> updateLeadEntity(leadEntity, lead));
    }

    private Lead updateLeadEntity(final LeadEntity leadEntity, final Lead lead) {
        leadEntity.setCpf(lead.getCpf());
        leadEntity.setCellphone(lead.getCellphone());
        leadEntity.setName(lead.getName());
        leadEntity.setBirthdate(lead.getBirthdate());
        leadEntity.setMotherFullName(lead.getMotherFullName());
        leadEntity.setStableUnion(lead.getStableUnion());
        leadEntity.setLastModifiedDateTime(lead.getLastModifiedDateTime());
        leadEntity.setSelfiePhoto(lead.getSelfiePhoto());
        leadEntity.setGender(lead.getGender().name());
        leadEntity.setEducation(lead.getEducation().name());
        leadEntity.setMaritalStatus(lead.getMaritalStatus().name());
        return leadMapper.of(leadRepository.saveAndFlush(leadEntity));
    }
}

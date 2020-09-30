package io.github.jtsato.bookstore.dataprovider.jobinformation;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.UpdateJobInformationByIdGateway;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;
import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.JobInformationEntity;
import io.github.jtsato.bookstore.dataprovider.jobinformation.mapper.JobInformationMapper;
import io.github.jtsato.bookstore.dataprovider.jobinformation.repository.JobInformationRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateJobInformationByIdDataProvider implements UpdateJobInformationByIdGateway {

    private final JobInformationMapper jobInformationMapper = Mappers.getMapper(JobInformationMapper.class);

    @Autowired
    JobInformationRepository jobInformationRepository;

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Optional<JobInformation> execute(final JobInformation jobInformation) {

        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead");
        final Optional<JobInformationEntity> optional = jobInformationRepository.findById(jobInformation.getId(), entityGraph);

        return optional.map(jobInformationEntity -> updateJobInformationEntity(jobInformationEntity, jobInformation));
    }

    private JobInformation updateJobInformationEntity(final JobInformationEntity jobInformationEntity, final JobInformation jobInformation) {
        updateLeadEntity(jobInformation, jobInformationEntity);
        jobInformationEntity.setProfession(jobInformation.getProfession());
        jobInformationEntity.setMonthlyIncome(jobInformation.getMonthlyIncome());
        jobInformationEntity.setReferenceMonth(jobInformation.getReferenceMonth());
        jobInformationEntity.setStartDate(jobInformation.getStartDate());
        jobInformationEntity.setAttach(jobInformation.getAttach());
        jobInformationEntity.setLastModifiedDateTime(jobInformation.getLastModifiedDateTime());
        jobInformationEntity.setReceiptType(jobInformation.getReceiptType().name());
        return jobInformationMapper.of(jobInformationRepository.saveAndFlush(jobInformationEntity));
    }

    private void updateLeadEntity(final JobInformation jobInformation, final JobInformationEntity jobInformationEntity) {
        final Long currentLeadId = jobInformationEntity.getLead().getId();
        final Long newLeadId = jobInformation.getLead().getId();
        if (!newLeadId.equals(currentLeadId)) {
            leadRepository.findById(newLeadId).ifPresent(jobInformationEntity::setLead);
        }
    }
}

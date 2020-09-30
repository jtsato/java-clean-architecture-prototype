package io.github.jtsato.bookstore.dataprovider.jobinformation;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.RegisterJobInformationGateway;
import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.JobInformationEntity;
import io.github.jtsato.bookstore.dataprovider.jobinformation.mapper.JobInformationMapper;
import io.github.jtsato.bookstore.dataprovider.jobinformation.repository.JobInformationRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterJobInformationDataProvider implements RegisterJobInformationGateway {

    private final JobInformationMapper jobInformationMapper = Mappers.getMapper(JobInformationMapper.class);
    
    @Autowired
    JobInformationRepository jobInformationRepository;

    @Override
    public JobInformation execute(final JobInformation jobInformation) {
        final JobInformationEntity jobInformationEntity = jobInformationMapper.of(jobInformation);
        return jobInformationMapper.of(jobInformationRepository.saveAndFlush(jobInformationEntity));
    }
}

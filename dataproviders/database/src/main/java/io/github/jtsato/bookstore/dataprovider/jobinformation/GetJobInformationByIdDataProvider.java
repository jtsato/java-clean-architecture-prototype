package io.github.jtsato.bookstore.dataprovider.jobinformation;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.GetJobInformationByIdGateway;
import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.JobInformationEntity;
import io.github.jtsato.bookstore.dataprovider.jobinformation.mapper.JobInformationMapper;
import io.github.jtsato.bookstore.dataprovider.jobinformation.repository.JobInformationRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetJobInformationByIdDataProvider implements GetJobInformationByIdGateway {

    private final JobInformationMapper jobInformationMapper = Mappers.getMapper(JobInformationMapper.class);
    
    @Autowired
    JobInformationRepository jobInformationRepository;

    @Override
    public Optional<JobInformation> execute(final Long id) {
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead");
        final Optional<JobInformationEntity> optional = jobInformationRepository.findById(id, entityGraph);
        return optional.map(jobInformationMapper::of);
    }
}

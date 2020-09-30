package io.github.jtsato.bookstore.dataprovider.jobinformation.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.JobInformationEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper(uses = {LeadMapper.class})
public interface JobInformationMapper {

    JobInformation of(final JobInformationEntity jobInformationEntity);

    JobInformationEntity of(final JobInformation jobInformation);
}

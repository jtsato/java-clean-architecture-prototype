package io.github.jtsato.bookstore.dataprovider.jobinformation;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.SearchJobInformationsByLeadIdGateway;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.JobInformationEntity;
import io.github.jtsato.bookstore.dataprovider.jobinformation.mapper.JobInformationMapper;
import io.github.jtsato.bookstore.dataprovider.jobinformation.repository.JobInformationRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchJobInformationsByLeadIdDataProvider implements SearchJobInformationsByLeadIdGateway {
    
	private final JobInformationMapper jobInformationMapper = Mappers.getMapper(JobInformationMapper.class);
    private final PageMapper<JobInformation, JobInformationEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    JobInformationRepository jobInformationRepository;

    @Override
    public Page<JobInformation> execute(final Long leadId, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
    	
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead");
        final org.springframework.data.domain.Page<JobInformationEntity> page = jobInformationRepository.findByLeadId(leadId, entityGraph, pageRequest);

        return pageMapper.of(page, jobInformationMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "profession:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

package io.github.jtsato.bookstore.dataprovider.lead;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.FindLeadsByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.domain.QLeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindLeadsByIdsDataProvider implements FindLeadsByIdsGateway {

    private final LeadMapper leadMapper = Mappers.getMapper(LeadMapper.class);
    private final PageMapper<Lead, LeadEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Page<Lead> execute(final List<Long> ids) {

        final BooleanExpression predicate = QLeadEntity.leadEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<LeadEntity> page = leadRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, leadMapper::of);
    }
}

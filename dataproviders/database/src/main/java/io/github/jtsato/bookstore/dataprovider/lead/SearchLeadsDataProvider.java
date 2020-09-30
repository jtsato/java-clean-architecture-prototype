package io.github.jtsato.bookstore.dataprovider.lead;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.SearchLeadsGateway;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.domain.QLeadEntity;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;
import io.github.jtsato.bookstore.dataprovider.lead.repository.SearchLeadsPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchLeadsDataProvider implements SearchLeadsGateway {
    
    private final LeadMapper leadMapper = Mappers.getMapper(LeadMapper.class);
    private final PageMapper<Lead, LeadEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Page<Lead> execute(final SearchLeadsParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchLeadsPredicateBuilder(QLeadEntity.leadEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<LeadEntity> page = leadRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, leadMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "cpf:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

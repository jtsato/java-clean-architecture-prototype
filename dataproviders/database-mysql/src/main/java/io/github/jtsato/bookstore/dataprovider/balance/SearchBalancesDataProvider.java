package io.github.jtsato.bookstore.dataprovider.balance;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.SearchBalancesGateway;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.SearchBalancesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.domain.QBalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.mapper.BalanceMapper;
import io.github.jtsato.bookstore.dataprovider.balance.repository.BalanceRepository;
import io.github.jtsato.bookstore.dataprovider.balance.repository.SearchBalancesPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchBalancesDataProvider implements SearchBalancesGateway {
    
    private final BalanceMapper balanceMapper = Mappers.getMapper(BalanceMapper.class);
    private final PageMapper<Balance, BalanceEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public Page<Balance> execute(final SearchBalancesParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchBalancesPredicateBuilder(QBalanceEntity.balanceEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<BalanceEntity> page = balanceRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, balanceMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "customerNumber:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

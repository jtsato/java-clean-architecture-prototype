package io.github.jtsato.bookstore.dataprovider.balance;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.FindBalancesByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.domain.QBalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.mapper.BalanceMapper;
import io.github.jtsato.bookstore.dataprovider.balance.repository.BalanceRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindBalancesByIdsDataProvider implements FindBalancesByIdsGateway {

    private final BalanceMapper balanceMapper = Mappers.getMapper(BalanceMapper.class);
    private final PageMapper<Balance, BalanceEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public Page<Balance> execute(final List<Long> ids) {

        final BooleanExpression predicate = QBalanceEntity.balanceEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<BalanceEntity> page = balanceRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, balanceMapper::of);
    }
}

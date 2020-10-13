package io.github.jtsato.bookstore.dataprovider.balance;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.GetBalanceByIdGateway;
import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.mapper.BalanceMapper;
import io.github.jtsato.bookstore.dataprovider.balance.repository.BalanceRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetBalanceByIdDataProvider implements GetBalanceByIdGateway {

    private final BalanceMapper balanceMapper = Mappers.getMapper(BalanceMapper.class);
    
    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public Optional<Balance> execute(final Long id) {
        final Optional<BalanceEntity> optional = balanceRepository.findById(id);
        return optional.map(balanceMapper::of);
    }
}

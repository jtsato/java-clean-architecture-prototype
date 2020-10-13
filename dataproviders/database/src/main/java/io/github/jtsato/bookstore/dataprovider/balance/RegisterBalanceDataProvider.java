package io.github.jtsato.bookstore.dataprovider.balance;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.RegisterBalanceGateway;
import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.mapper.BalanceMapper;
import io.github.jtsato.bookstore.dataprovider.balance.repository.BalanceRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterBalanceDataProvider implements RegisterBalanceGateway {

    private final BalanceMapper balanceMapper = Mappers.getMapper(BalanceMapper.class);
    
    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public Balance execute(final Balance balance) {
        final BalanceEntity balanceEntity = balanceMapper.of(balance);
        return balanceMapper.of(balanceRepository.saveAndFlush(balanceEntity));
    }
}

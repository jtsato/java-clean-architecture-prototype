package io.github.jtsato.bookstore.dataprovider.balance;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.core.balance.gateway.UpdateBalanceByIdGateway;
import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;
import io.github.jtsato.bookstore.dataprovider.balance.mapper.BalanceMapper;
import io.github.jtsato.bookstore.dataprovider.balance.repository.BalanceRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateBalanceByIdDataProvider implements UpdateBalanceByIdGateway {

    private final BalanceMapper balanceMapper = Mappers.getMapper(BalanceMapper.class);

    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public Optional<Balance> execute(final Balance balance) {

        final Optional<BalanceEntity> optional = balanceRepository.findById(balance.getId());

        return optional.map(balanceEntity -> updateBalanceEntity(balanceEntity, balance));
    }

    private Balance updateBalanceEntity(final BalanceEntity balanceEntity, final Balance balance) {
        balanceEntity.setCustomerNumber(balance.getCustomerNumber());
        balanceEntity.setCurrency1(balance.getCurrency1());
        balanceEntity.setResourceOrigin1(balance.getResourceOrigin1());
        balanceEntity.setDebitBalance(balance.getDebitBalance());
        balanceEntity.setContractedPrincipal(balance.getContractedPrincipal());
        balanceEntity.setContractedInterest(balance.getContractedInterest());
        balanceEntity.setContractedTotal(balance.getContractedTotal());
        balanceEntity.setPaidPrincipal(balance.getPaidPrincipal());
        balanceEntity.setPaidInterest(balance.getPaidInterest());
        balanceEntity.setPaidTotal(balance.getPaidTotal());
        balanceEntity.setCurrency(balance.getCurrency().name());
        balanceEntity.setResourceOrigin(balance.getResourceOrigin().name());
        return balanceMapper.of(balanceRepository.saveAndFlush(balanceEntity));
    }
}

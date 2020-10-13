package io.github.jtsato.bookstore.dataprovider.balance.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.balance.domain.Balance;
import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface BalanceMapper {

    Balance of(final BalanceEntity balanceEntity);

    BalanceEntity of(final Balance balance);
}

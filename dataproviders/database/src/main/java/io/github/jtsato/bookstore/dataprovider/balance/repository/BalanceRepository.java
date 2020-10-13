package io.github.jtsato.bookstore.dataprovider.balance.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.balance.domain.BalanceEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface BalanceRepository extends EntityGraphJpaRepository<BalanceEntity, Long>, EntityGraphQuerydslPredicateExecutor<BalanceEntity> {

    Optional<BalanceEntity> findById(final Long id);

    Optional<BalanceEntity> findByCustomerNumberIgnoreCase(final String customerNumber);

    Optional<BalanceEntity> findByCurrency(final String currency);

    Optional<BalanceEntity> findByResourceOrigin(final String resourceOrigin);
}

package io.github.jtsato.bookstore.dataprovider.customer.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.customer.domain.CustomerEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface CustomerRepository extends EntityGraphJpaRepository<CustomerEntity, Long>, EntityGraphQuerydslPredicateExecutor<CustomerEntity> {

    Optional<CustomerEntity> findById(final Long id);

    Optional<CustomerEntity> findByNameIgnoreCase(final String name);

    Optional<CustomerEntity> findByAddressIgnoreCase(final String address);
}

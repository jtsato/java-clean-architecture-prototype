package io.github.jtsato.bookstore.dataprovider.country.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface CountryRepository extends EntityGraphJpaRepository<CountryEntity, Long>, EntityGraphQuerydslPredicateExecutor<CountryEntity> {

    Optional<CountryEntity> findById(final Long id);

    Optional<CountryEntity> findByNameIgnoreCase(final String name);
}

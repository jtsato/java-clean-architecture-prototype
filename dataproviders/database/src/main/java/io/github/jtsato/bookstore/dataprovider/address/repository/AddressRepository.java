package io.github.jtsato.bookstore.dataprovider.address.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.address.domain.AddressEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface AddressRepository extends EntityGraphJpaRepository<AddressEntity, Long>, EntityGraphQuerydslPredicateExecutor<AddressEntity> {

    Optional<AddressEntity> findById(final Long id, final EntityGraph entityGraph);

    Page<AddressEntity> findByLeadId(final Long leadId, final EntityGraph entityGraph, final PageRequest pageRequest);

    Optional<AddressEntity> findByZipCodeIgnoreCase(final String zipCode, final EntityGraph entityGraph);

    Optional<AddressEntity> findByCityIgnoreCase(final String city, final EntityGraph entityGraph);

    Optional<AddressEntity> findByStateIgnoreCase(final String state, final EntityGraph entityGraph);

    Optional<AddressEntity> findByCountryIgnoreCase(final String country, final EntityGraph entityGraph);

    Optional<AddressEntity> findByDescriptionIgnoreCase(final String description, final EntityGraph entityGraph);

    Optional<AddressEntity> findByComplementIgnoreCase(final String complement, final EntityGraph entityGraph);

    Optional<AddressEntity> findByNumberIgnoreCase(final String number, final EntityGraph entityGraph);

    Optional<AddressEntity> findByType(final String type, final EntityGraph entityGraph);
}

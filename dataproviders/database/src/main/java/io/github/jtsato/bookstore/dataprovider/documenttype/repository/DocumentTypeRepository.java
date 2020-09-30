package io.github.jtsato.bookstore.dataprovider.documenttype.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface DocumentTypeRepository extends EntityGraphJpaRepository<DocumentTypeEntity, Long>, EntityGraphQuerydslPredicateExecutor<DocumentTypeEntity> {

    Optional<DocumentTypeEntity> findById(final Long id);

    Optional<DocumentTypeEntity> findByCountryIgnoreCase(final String country);

    Optional<DocumentTypeEntity> findByDescriptionIgnoreCase(final String description);
}

package io.github.jtsato.bookstore.dataprovider.document.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface DocumentRepository extends EntityGraphJpaRepository<DocumentEntity, Long>, EntityGraphQuerydslPredicateExecutor<DocumentEntity> {

    Optional<DocumentEntity> findById(final Long id, final EntityGraph entityGraph);

    Page<DocumentEntity> findByLeadId(final Long leadId, final EntityGraph entityGraph, final PageRequest pageRequest);

    Page<DocumentEntity> findByTypeId(final Long typeId, final EntityGraph entityGraph, final PageRequest pageRequest);

    Optional<DocumentEntity> findByFrontPhoto(final Long frontPhoto, final EntityGraph entityGraph);

    Optional<DocumentEntity> findByBackPhoto(final Long backPhoto, final EntityGraph entityGraph);

    Optional<DocumentEntity> findByNumberIgnoreCase(final String number, final EntityGraph entityGraph);

    Optional<DocumentEntity> findByIssuerIgnoreCase(final String issuer, final EntityGraph entityGraph);

    Optional<DocumentEntity> findByStateIgnoreCase(final String state, final EntityGraph entityGraph);
}

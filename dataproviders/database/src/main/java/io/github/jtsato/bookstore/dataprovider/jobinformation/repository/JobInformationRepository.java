package io.github.jtsato.bookstore.dataprovider.jobinformation.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.JobInformationEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface JobInformationRepository extends EntityGraphJpaRepository<JobInformationEntity, Long>, EntityGraphQuerydslPredicateExecutor<JobInformationEntity> {

    Optional<JobInformationEntity> findById(final Long id, final EntityGraph entityGraph);

    Page<JobInformationEntity> findByLeadId(final Long leadId, final EntityGraph entityGraph, final PageRequest pageRequest);

    Optional<JobInformationEntity> findByAttach(final Long attach, final EntityGraph entityGraph);

    Optional<JobInformationEntity> findByProfessionIgnoreCase(final String profession, final EntityGraph entityGraph);

    Optional<JobInformationEntity> findByReferenceMonthIgnoreCase(final String referenceMonth, final EntityGraph entityGraph);

    Optional<JobInformationEntity> findByReceiptType(final String receiptType, final EntityGraph entityGraph);
}

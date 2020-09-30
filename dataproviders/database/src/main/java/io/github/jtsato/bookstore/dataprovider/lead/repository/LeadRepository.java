package io.github.jtsato.bookstore.dataprovider.lead.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface LeadRepository extends EntityGraphJpaRepository<LeadEntity, Long>, EntityGraphQuerydslPredicateExecutor<LeadEntity> {

    Optional<LeadEntity> findById(final Long id);

    Optional<LeadEntity> findBySelfiePhoto(final Long selfiePhoto);

    Optional<LeadEntity> findByCpfIgnoreCase(final String cpf);

    Optional<LeadEntity> findByCellphoneIgnoreCase(final String cellphone);

    Optional<LeadEntity> findByNameIgnoreCase(final String name);

    Optional<LeadEntity> findByMotherFullNameIgnoreCase(final String motherFullName);

    Optional<LeadEntity> findByGender(final String gender);

    Optional<LeadEntity> findByEducation(final String education);

    Optional<LeadEntity> findByMaritalStatus(final String maritalStatus);

    Optional<LeadEntity> findByStableUnion(final Boolean stableUnion);
}

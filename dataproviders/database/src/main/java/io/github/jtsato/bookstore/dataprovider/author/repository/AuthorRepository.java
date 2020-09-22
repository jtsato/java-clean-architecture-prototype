package io.github.jtsato.bookstore.dataprovider.author.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface AuthorRepository extends EntityGraphJpaRepository<AuthorEntity, Long>, EntityGraphQuerydslPredicateExecutor<AuthorEntity> {

    Optional<AuthorEntity> findById(final Long id, final EntityGraph entityGraph);

    Page<AuthorEntity> findByCountryId(final Long countryId, final EntityGraph entityGraph, final PageRequest pageRequest);

    Optional<AuthorEntity> findByGender(final String gender, final EntityGraph entityGraph);

    Optional<AuthorEntity> findByNameIgnoreCase(final String name, final EntityGraph entityGraph);
}

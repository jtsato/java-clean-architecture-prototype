package io.github.jtsato.bookstore.dataprovider.bookdocument.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface BookDocumentRepository extends EntityGraphJpaRepository<BookDocumentEntity, Long>, EntityGraphQuerydslPredicateExecutor<BookDocumentEntity> {

    Optional<BookDocumentEntity> findByXxx(final Long xxx, final EntityGraph entityGraph);

    Page<BookDocumentEntity> findByBookBKey(final Long bookBKey, final EntityGraph entityGraph, final PageRequest pageRequest);

    Optional<BookDocumentEntity> findByContentTypeIgnoreCase(final String contentType, final EntityGraph entityGraph);

    Optional<BookDocumentEntity> findByExtensionIgnoreCase(final String extension, final EntityGraph entityGraph);

    Optional<BookDocumentEntity> findByNameIgnoreCase(final String name, final EntityGraph entityGraph);

    Optional<BookDocumentEntity> findByContentIgnoreCase(final String content, final EntityGraph entityGraph);
}

package io.github.jtsato.bookstore.dataprovider.bookdocument.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface BookDocumentRepository extends EntityGraphJpaRepository<BookDocumentEntity, Long>, EntityGraphQuerydslPredicateExecutor<BookDocumentEntity> {

    Optional<BookDocumentEntity> findByContentTypeIgnoreCase(final String contentType);

    Optional<BookDocumentEntity> findByExtensionIgnoreCase(final String extension);

    Optional<BookDocumentEntity> findByNameIgnoreCase(final String name);

    Optional<BookDocumentEntity> findByContentIgnoreCase(final String content);
}

package io.github.jtsato.bookstore.dataprovider.file.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;

import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Repository
public interface FileRepository extends EntityGraphJpaRepository<FileEntity, Long>, EntityGraphQuerydslPredicateExecutor<FileEntity> {

    Optional<FileEntity> findById(final Long id);

    Optional<FileEntity> findBySize(final Long size);

    Optional<FileEntity> findByContentTypeIgnoreCase(final String contentType);

    Optional<FileEntity> findByExtensionIgnoreCase(final String extension);

    Optional<FileEntity> findByNameIgnoreCase(final String name);

    Optional<FileEntity> findByContentIgnoreCase(final String content);

    Optional<FileEntity> findByUrlIgnoreCase(final String url);
}

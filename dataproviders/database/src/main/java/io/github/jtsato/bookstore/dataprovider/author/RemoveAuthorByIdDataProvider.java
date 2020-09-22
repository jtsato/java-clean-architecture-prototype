package io.github.jtsato.bookstore.dataprovider.author;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.RemoveAuthorByIdGateway;
import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;
import io.github.jtsato.bookstore.dataprovider.author.mapper.AuthorMapper;
import io.github.jtsato.bookstore.dataprovider.author.repository.AuthorRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RemoveAuthorByIdDataProvider implements RemoveAuthorByIdGateway {

    private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);
    
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Optional<Author> execute(final Long id) {

        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("country");
        final Optional<AuthorEntity> optional = authorRepository.findById(id, entityGraph);

        return optional.map(this::removeAuthorEntity);
    }

    private Author removeAuthorEntity(final AuthorEntity authorEntity) {
        final Author author = authorMapper.of(authorEntity);
        authorRepository.delete(authorEntity);
        return author;
    }
}

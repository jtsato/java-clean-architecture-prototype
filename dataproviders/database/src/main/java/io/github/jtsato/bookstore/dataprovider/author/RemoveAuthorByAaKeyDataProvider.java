package io.github.jtsato.bookstore.dataprovider.author;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.RemoveAuthorByAaKeyGateway;
import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;
import io.github.jtsato.bookstore.dataprovider.author.mapper.AuthorMapper;
import io.github.jtsato.bookstore.dataprovider.author.repository.AuthorRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RemoveAuthorByAaKeyDataProvider implements RemoveAuthorByAaKeyGateway {

    private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);
    
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Optional<Author> execute(final Long aaKey) {

        final Optional<AuthorEntity> optional = authorRepository.findByAaKey(aaKey);

        return optional.map(this::removeAuthorEntity);
    }

    private Author removeAuthorEntity(final AuthorEntity authorEntity) {
        final Author author = authorMapper.of(authorEntity);
        authorRepository.delete(authorEntity);
        return author;
    }
}

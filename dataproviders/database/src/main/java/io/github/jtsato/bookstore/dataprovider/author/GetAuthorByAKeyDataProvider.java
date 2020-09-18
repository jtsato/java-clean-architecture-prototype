package io.github.jtsato.bookstore.dataprovider.author;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.GetAuthorByAKeyGateway;
import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;
import io.github.jtsato.bookstore.dataprovider.author.mapper.AuthorMapper;
import io.github.jtsato.bookstore.dataprovider.author.repository.AuthorRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetAuthorByAKeyDataProvider implements GetAuthorByAKeyGateway {

    private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);
    
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Optional<Author> execute(final Long id) {
        final Optional<AuthorEntity> optional = authorRepository.findByAKey(id);
        return optional.map(authorMapper::of);
    }
}

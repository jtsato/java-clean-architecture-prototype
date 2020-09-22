package io.github.jtsato.bookstore.dataprovider.author.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.dataprovider.country.mapper.CountryMapper;
import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper(uses = {CountryMapper.class})
public interface AuthorMapper {

    Author of(final AuthorEntity authorEntity);

    AuthorEntity of(final Author author);
}

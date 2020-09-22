package io.github.jtsato.bookstore.dataprovider.author;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.gateway.SearchAuthorsByCountryIdGateway;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;
import io.github.jtsato.bookstore.dataprovider.author.mapper.AuthorMapper;
import io.github.jtsato.bookstore.dataprovider.author.repository.AuthorRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchAuthorsByCountryIdDataProvider implements SearchAuthorsByCountryIdGateway {
    
	private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);
    private final PageMapper<Author, AuthorEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Page<Author> execute(final Long countryId, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
    	
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("country");
        final org.springframework.data.domain.Page<AuthorEntity> page = authorRepository.findByCountryId(countryId, entityGraph, pageRequest);

        return pageMapper.of(page, authorMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "name:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

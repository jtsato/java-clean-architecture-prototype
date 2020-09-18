package io.github.jtsato.bookstore.dataprovider.bookdocument;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.SearchBookDocumentsByBookBKeyGateway;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchBookDocumentsByBookBKeyDataProvider implements SearchBookDocumentsByBookBKeyGateway {
    
	private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    private final PageMapper<BookDocument, BookDocumentEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Page<BookDocument> execute(final Long bookBKey, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
    	
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("book");
        final org.springframework.data.domain.Page<BookDocumentEntity> page = bookDocumentRepository.findByBookBKey(bookBKey, entityGraph, pageRequest);

        return pageMapper.of(page, bookDocumentMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "contentType:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

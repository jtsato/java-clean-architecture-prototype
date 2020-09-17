package io.github.jtsato.bookstore.dataprovider.bookdocument;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.SearchBookDocumentsGateway;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.SearchBookDocumentsParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.QBookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.SearchBookDocumentsPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchBookDocumentsDataProvider implements SearchBookDocumentsGateway {
    
    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    private final PageMapper<BookDocument, BookDocumentEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Page<BookDocument> execute(final SearchBookDocumentsParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchBookDocumentsPredicateBuilder(QBookDocumentEntity.bookDocumentEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<BookDocumentEntity> page = bookDocumentRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, bookDocumentMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "contentType:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}

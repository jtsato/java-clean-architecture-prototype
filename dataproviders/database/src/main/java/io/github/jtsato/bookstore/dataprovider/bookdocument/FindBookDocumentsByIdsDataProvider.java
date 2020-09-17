package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.FindBookDocumentsByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.QBookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindBookDocumentsByIdsDataProvider implements FindBookDocumentsByIdsGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    private final PageMapper<BookDocument, BookDocumentEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Page<BookDocument> execute(final List<Long> ids) {

        final BooleanExpression predicate = QBookDocumentEntity.bookDocumentEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<BookDocumentEntity> page = bookDocumentRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, bookDocumentMapper::of);
    }
}

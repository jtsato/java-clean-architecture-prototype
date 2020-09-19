package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.FindBookDocumentsByXxKeysGateway;
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
public class FindBookDocumentsByXxKeysDataProvider implements FindBookDocumentsByXxKeysGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    private final PageMapper<BookDocument, BookDocumentEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Page<BookDocument> execute(final List<Long> xxKeys) {

        final BooleanExpression predicate = QBookDocumentEntity.bookDocumentEntity.xxKey.in(xxKeys);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "xxKey:asc");
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("book");
        final org.springframework.data.domain.Page<BookDocumentEntity> page = bookDocumentRepository.findAll(predicate, pageRequest, entityGraph);
    
        return pageMapper.of(page, bookDocumentMapper::of);
    }
}

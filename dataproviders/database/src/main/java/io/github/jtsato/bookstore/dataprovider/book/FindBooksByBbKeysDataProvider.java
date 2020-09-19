package io.github.jtsato.bookstore.dataprovider.book;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.FindBooksByBbKeysGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.book.domain.BookEntity;
import io.github.jtsato.bookstore.dataprovider.book.domain.QBookEntity;
import io.github.jtsato.bookstore.dataprovider.book.mapper.BookMapper;
import io.github.jtsato.bookstore.dataprovider.book.repository.BookRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindBooksByBbKeysDataProvider implements FindBooksByBbKeysGateway {

    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);
    private final PageMapper<Book, BookEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> execute(final List<Long> bbKeys) {

        final BooleanExpression predicate = QBookEntity.bookEntity.bbKey.in(bbKeys);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "bbKey:asc");
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("author");
        final org.springframework.data.domain.Page<BookEntity> page = bookRepository.findAll(predicate, pageRequest, entityGraph);
    
        return pageMapper.of(page, bookMapper::of);
    }
}

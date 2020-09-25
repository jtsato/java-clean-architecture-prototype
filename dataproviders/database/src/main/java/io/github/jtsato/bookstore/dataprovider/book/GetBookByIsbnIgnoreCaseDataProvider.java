package io.github.jtsato.bookstore.dataprovider.book;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;


import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.GetBookByIsbnIgnoreCaseGateway;
import io.github.jtsato.bookstore.dataprovider.book.domain.BookEntity;
import io.github.jtsato.bookstore.dataprovider.book.mapper.BookMapper;
import io.github.jtsato.bookstore.dataprovider.book.repository.BookRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetBookByIsbnIgnoreCaseDataProvider implements GetBookByIsbnIgnoreCaseGateway {

    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    @Autowired
    BookRepository bookRepository;

    @Override
    public Optional<Book> execute(final String isbn) {
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("author");
        final Optional<BookEntity> optional = bookRepository.findByIsbnIgnoreCase(isbn, entityGraph);
        return optional.map(bookMapper::of);
    }
}
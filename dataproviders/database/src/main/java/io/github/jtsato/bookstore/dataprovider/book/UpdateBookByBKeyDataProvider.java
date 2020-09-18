package io.github.jtsato.bookstore.dataprovider.book;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.book.gateway.UpdateBookByBKeyGateway;
import io.github.jtsato.bookstore.dataprovider.author.repository.AuthorRepository;
import io.github.jtsato.bookstore.dataprovider.book.domain.BookEntity;
import io.github.jtsato.bookstore.dataprovider.book.mapper.BookMapper;
import io.github.jtsato.bookstore.dataprovider.book.repository.BookRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateBookByBKeyDataProvider implements UpdateBookByBKeyGateway {
    
    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Optional<Book> execute(final Book book) {
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("author");
        final Optional<BookEntity> optional = bookRepository.findByBKey(book.getBKey(), entityGraph);

        return optional.map(bookEntity -> updateBookEntity(bookEntity, book));
    }

    private Book updateBookEntity(final BookEntity bookEntity, final Book book) {
        updateAuthor(book, bookEntity);
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAvailable(book.getAvailable());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setLastModifiedDate(book.getLastModifiedDate());
        return bookMapper.of(bookRepository.saveAndFlush(bookEntity));
    }

    private void updateAuthor(final Book book, final BookEntity bookEntity) {
        final Long currentAuthorAKey = bookEntity.getAuthor().getAKey();
        final Long newAuthorAKey = book.getAuthor().getAKey();
        if (!newAuthorAKey.equals(currentAuthorAKey)) {
            authorRepository.findByAKey(newAuthorAKey).ifPresent(bookEntity::setAuthor);
        }
    }
}

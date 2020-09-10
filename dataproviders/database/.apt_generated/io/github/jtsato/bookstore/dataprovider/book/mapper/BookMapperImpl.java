package io.github.jtsato.bookstore.dataprovider.book.mapper;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.dataprovider.book.domain.BookEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-10T00:08:44-0300",
    comments = "version: 1.4.0.Beta3, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 11.0.7 (GraalVM Community)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book of(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        Long id = null;
        Author author = null;
        String title = null;
        BigDecimal price = null;
        boolean available = false;
        LocalDateTime creationDate = null;
        LocalDateTime updateDate = null;

        id = bookEntity.getId();
        author = bookEntity.getAuthor();
        title = bookEntity.getTitle();
        price = bookEntity.getPrice();
        available = bookEntity.isAvailable();
        creationDate = bookEntity.getCreationDate();
        updateDate = bookEntity.getUpdateDate();

        Book book = new Book( id, author, title, price, available, creationDate, updateDate );

        return book;
    }

    @Override
    public BookEntity of(Book book) {
        if ( book == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthor( book.getAuthor() );
        bookEntity.setAvailable( book.isAvailable() );
        bookEntity.setCreationDate( book.getCreationDate() );
        bookEntity.setId( book.getId() );
        bookEntity.setPrice( book.getPrice() );
        bookEntity.setTitle( book.getTitle() );
        bookEntity.setUpdateDate( book.getUpdateDate() );

        return bookEntity;
    }
}

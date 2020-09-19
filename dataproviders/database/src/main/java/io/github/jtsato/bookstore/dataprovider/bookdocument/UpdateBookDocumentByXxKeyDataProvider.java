package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.UpdateBookDocumentByXxKeyGateway;
import io.github.jtsato.bookstore.dataprovider.book.repository.BookRepository;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateBookDocumentByXxKeyDataProvider implements UpdateBookDocumentByXxKeyGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public Optional<BookDocument> execute(final BookDocument bookDocument) {

        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("book");
        final Optional<BookDocumentEntity> optional = bookDocumentRepository.findByXxKey(bookDocument.getXxKey(), entityGraph);

        return optional.map(bookDocumentEntity -> updateBookDocumentEntity(bookDocumentEntity, bookDocument));
    }

    private BookDocument updateBookDocumentEntity(final BookDocumentEntity bookDocumentEntity, final BookDocument bookDocument) {
        updateBookEntity(bookDocument, bookDocumentEntity);
        bookDocumentEntity.setContentType(bookDocument.getContentType());
        bookDocumentEntity.setExtension(bookDocument.getExtension());
        bookDocumentEntity.setName(bookDocument.getName());
        bookDocumentEntity.setSize(bookDocument.getSize());
        bookDocumentEntity.setContent(bookDocument.getContent());
        bookDocumentEntity.setCreationDate(bookDocument.getCreationDate());
        bookDocumentEntity.setLastModifiedDate(bookDocument.getLastModifiedDate());
        return bookDocumentMapper.of(bookDocumentRepository.saveAndFlush(bookDocumentEntity));
    }

    private void updateBookEntity(final BookDocument bookDocument, final BookDocumentEntity bookDocumentEntity) {
        final Long currentBookBbKey = bookDocumentEntity.getBook().getBbKey();
        final Long newBookBbKey = bookDocument.getBook().getBbKey();
        if (!newBookBbKey.equals(currentBookBbKey)) {
            final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("author");
            bookRepository.findByBbKey(newBookBbKey, entityGraph).ifPresent(bookDocumentEntity::setBook);
        }
    }
}

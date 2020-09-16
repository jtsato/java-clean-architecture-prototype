package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.UpdateBookDocumentByIdGateway;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateBookDocumentByIdDataProvider implements UpdateBookDocumentByIdGateway {
    
    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Optional<BookDocument> execute(final BookDocument bookDocument) {
        final Optional<BookDocumentEntity> optional = bookDocumentRepository.findById(bookDocument.getId());
        return optional.map(bookDocumentEntity -> updateBookDocumentEntity(bookDocumentEntity, bookDocument));
    }

    private BookDocument updateBookDocumentEntity(final BookDocumentEntity bookDocumentEntity, final BookDocument bookDocument) {
        bookDocumentEntity.setBookId(bookDocument.getBookId());
        bookDocumentEntity.setContentType(bookDocument.getContentType());
        bookDocumentEntity.setExtension(bookDocument.getExtension());
        bookDocumentEntity.setName(bookDocument.getName());
        bookDocumentEntity.setSize(bookDocument.getSize());
        bookDocumentEntity.setContent(bookDocument.getContent());
        bookDocumentEntity.setCreationDate(bookDocument.getCreationDate());
        bookDocumentEntity.setLastModifiedDate(bookDocument.getLastModifiedDate());
        return bookDocumentMapper.of(bookDocumentRepository.saveAndFlush(bookDocumentEntity));
    }
}

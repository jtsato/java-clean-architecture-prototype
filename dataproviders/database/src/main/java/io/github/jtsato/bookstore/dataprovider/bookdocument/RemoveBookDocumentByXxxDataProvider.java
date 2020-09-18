package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RemoveBookDocumentByXxxGateway;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RemoveBookDocumentByXxxDataProvider implements RemoveBookDocumentByXxxGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    
    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Optional<BookDocument> execute(final Long xxx) {

        final Optional<BookDocumentEntity> optional = bookDocumentRepository.findByXxx(xxx);

        return optional.map(this::removeBookDocumentEntity);
    }

    private BookDocument removeBookDocumentEntity(final BookDocumentEntity bookDocumentEntity) {
        final BookDocument bookDocument = bookDocumentMapper.of(bookDocumentEntity);
        bookDocumentRepository.delete(bookDocumentEntity);
        return bookDocument;
    }
}

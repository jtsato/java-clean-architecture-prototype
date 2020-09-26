package io.github.jtsato.bookstore.dataprovider.bookdocument;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RegisterBookDocumentGateway;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterBookDocumentDataProvider implements RegisterBookDocumentGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    
    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public BookDocument execute(final BookDocument bookDocument) {
        final BookDocumentEntity bookDocumentEntity = bookDocumentMapper.of(bookDocument);
        return bookDocumentMapper.of(bookDocumentRepository.saveAndFlush(bookDocumentEntity));
    }
}

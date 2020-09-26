package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.RemoveBookDocumentByXxKeyGateway;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RemoveBookDocumentByXxKeyDataProvider implements RemoveBookDocumentByXxKeyGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);
    
    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Optional<BookDocument> execute(final Long xxKey) {

        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("book");
        final Optional<BookDocumentEntity> optional = bookDocumentRepository.findByXxKey(xxKey, entityGraph);

        return optional.map(this::removeBookDocumentEntity);
    }

    private BookDocument removeBookDocumentEntity(final BookDocumentEntity bookDocumentEntity) {
        final BookDocument bookDocument = bookDocumentMapper.of(bookDocumentEntity);
        bookDocumentRepository.delete(bookDocumentEntity);
        return bookDocument;
    }
}

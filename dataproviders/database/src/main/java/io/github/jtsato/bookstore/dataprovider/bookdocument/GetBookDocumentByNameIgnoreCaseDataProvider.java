package io.github.jtsato.bookstore.dataprovider.bookdocument;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;


import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.gateway.GetBookDocumentByNameIgnoreCaseGateway;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.bookdocument.mapper.BookDocumentMapper;
import io.github.jtsato.bookstore.dataprovider.bookdocument.repository.BookDocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetBookDocumentByNameIgnoreCaseDataProvider implements GetBookDocumentByNameIgnoreCaseGateway {

    private final BookDocumentMapper bookDocumentMapper = Mappers.getMapper(BookDocumentMapper.class);

    @Autowired
    BookDocumentRepository bookDocumentRepository;

    @Override
    public Optional<BookDocument> execute(final String name) {
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("book");
        final Optional<BookDocumentEntity> optional = bookDocumentRepository.findByNameIgnoreCase(name, entityGraph);
        return optional.map(bookDocumentMapper::of);
    }
}
